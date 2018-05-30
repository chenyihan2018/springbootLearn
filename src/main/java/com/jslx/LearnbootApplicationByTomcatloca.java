package com.jslx;/**
 * Created by chenjia on 2018/5/28.
 */

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author chenjia
 * @create 2018-05-28 16:59
 * @desc
 **/
@SpringBootApplication
@ComponentScan(basePackages = "com.jslx")
@EnableScheduling
public class LearnbootApplicationByTomcatloca extends SpringBootServletInitializer {

}
