package com.example.service;

import com.example.domain.Admin;
import org.springframework.dao.DataAccessException;

public interface AdminService {

    public boolean Login(Admin admin) throws DataAccessException;
}
