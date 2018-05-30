package com.jslx.interceptor;/**
 * Created by chenjia on 2018/5/30.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author chenjia
 * @create 2018-05-30 11:15
 * @desc
 **/
public class InterceptorConfig implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);
    /**
     * 进入controller层之前拦截请求
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.out.println("----------------------------------------------------------------------");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取访问路径
        StringBuffer requestURL = httpServletRequest.getRequestURL();
        if(requestURL!=null){
            System.out.println("访问路径 : "+ requestURL.toString());
            System.out.println("访问方法 : "+ httpServletRequest.getRequestURI().toString());
            System.out.println("访问时间 : "+ sdf.format(new Date()));
            StringBuilder sb = new StringBuilder();
            Map<String,String> parameterMap = httpServletRequest.getParameterMap();
            if(parameterMap!=null && parameterMap.size()>0 ){
                for (Map.Entry<String,String> entry : parameterMap.entrySet()) {
                    String key = entry.getKey();
                    String value ="";
                    Object valueObj = entry.getValue();
                    if(null == valueObj){
                        value = "";
                    }else if(valueObj instanceof String[]){
                        String[] values = (String[])valueObj;
                        for(int i=0;i<values.length;i++){
                            value = values[i] + ",";
                        }
                        value = value.substring(0, value.length()-1);
                    }else{
                        value = valueObj.toString();
                    }

                    sb.append( key + "="+ value ).append(" ,");
                }
                String paraSb = sb.substring(0, sb.toString().length() - 1);
                System.out.println("访问参数 : "+ paraSb );
            }
        }
        System.out.println("----------------------------------------------------------------------");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        log.info("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        log.info("---------------视图渲染之后的操作-------------------------0");
    }
}
