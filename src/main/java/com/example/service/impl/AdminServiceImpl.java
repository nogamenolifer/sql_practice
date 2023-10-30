package com.example.service.impl;

import com.example.dao.AdmDao;
import com.example.domain.Admin;
import com.example.exception.BusinessException;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

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
}
