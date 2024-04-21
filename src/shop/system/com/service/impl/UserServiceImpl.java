package com.service.impl;

import com.dao.Mapper.UserMapper;
import com.entity.UserInfo;
import com.service.UserService;

public class UserServiceImpl implements UserService {

    com.dao.UserMapper userMapper = new UserMapper();

    /**
     * 注册
     * @param userInfo
     * @return
     */
    @Override
    public boolean register(UserInfo userInfo) {
        try {
            boolean register = userMapper.register(userInfo);
            return register;
        }catch (Exception e){
            return false;
        }

    }

    /**
     * 登录
     * @param userInfo
     * @return
     */
    @Override
    public UserInfo login(UserInfo userInfo) {
        try {
            UserInfo userInfo1 = userMapper.login(userInfo);
            if (userInfo1 != null){
                return userInfo1;
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

}
