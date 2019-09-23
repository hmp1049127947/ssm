package com.wyu160802.service.impl;

import com.wyu160802.dao.UserDao;
import com.wyu160802.entity.User;
import com.wyu160802.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 黄明潘
 * @date 2019/9/23-19:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User queryUser() {
        return userDao.queryUser();
    }
}
