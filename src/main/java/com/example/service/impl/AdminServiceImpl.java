package com.example.service.impl;

import com.example.dao.AdmDao;
import com.example.domain.Admin;
import com.example.domain.User;
import com.example.exception.BusinessException;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdmDao admDao;

    @Override
    public boolean Login(Admin admin) {
        System.out.println(admDao.getById(admin.getAdminId()));
//        if(1 == 1)//异常测试使用
//        {
//            throw new BusinessException(10001, "error");
//        }
        return admin.equals(admDao.getById(admin.getAdminId()));
    }

    @Override
    public List<User> getAll() {
        return admDao.getAll();
    }

    @Override
    public User getById(String userid) {
        return admDao.getByUserid(userid);
    }

    @Override
    public boolean save(User user) {
        return admDao.save(user) > 0;
    }

    @Override
    public boolean delete(String userid) {
        return admDao.delete(userid) > 0;
    }

    @Override
    public boolean update(User user) {
        return admDao.update(user) > 0;
    }
}
