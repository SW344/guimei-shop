package com.service;

import com.entity.UserInfo;

public interface UserService {

    /**
     * 注册
     * @param userInfo
     * @return
     */
    public boolean register(UserInfo userInfo);

    /**
     * 登录
     * @param userInfo
     * @return
     */
    UserInfo login(UserInfo userInfo);
}
