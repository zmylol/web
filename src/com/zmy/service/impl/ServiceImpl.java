package com.zmy.service.impl;

import com.zmy.dao.UserDao;
import com.zmy.entity.User;
import com.zmy.service.Service;


public class ServiceImpl implements Service {


    @Override
    public  boolean ifExist(User user) {
        return UserDao.check(user);
    }
}
