package com.miaoph.cn.service.impl;

import com.miaoph.cn.entity.PhUser;
import com.miaoph.cn.mapper.PhUserDao;
import com.miaoph.cn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    PhUserDao phUserDao;
    @Override
    public PhUser getUser() {
        return  phUserDao.queryById(1);
    }
}
