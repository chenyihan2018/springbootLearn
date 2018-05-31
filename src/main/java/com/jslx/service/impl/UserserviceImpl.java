package com.jslx.service.impl;/**
 * Created by chenjia on 2018/5/30.
 */

import com.jslx.mapper.UserMapper;
import com.jslx.model.User;
import com.jslx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenjia
 * @create 2018-05-30 23:12
 * @desc
 **/
@Service
public class UserserviceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUsernameAndPassword(User user) {
        return  userMapper.selectByUsernameAndPassword(user);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
