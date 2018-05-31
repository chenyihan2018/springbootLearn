package com.jslx.service;/**
 * Created by chenjia on 2018/5/30.
 */

import com.jslx.model.User;

/**
 * @author chenjia
 * @create 2018-05-30 23:11
 * @desc
 **/
public interface UserService {
    public User selectByUsernameAndPassword(User user);

    public User selectById(Integer id);
}
