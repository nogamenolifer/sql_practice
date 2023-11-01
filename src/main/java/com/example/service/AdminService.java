package com.example.service;

import com.example.domain.Admin;
import com.example.domain.User;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface AdminService {

    public boolean Login(Admin admin);

    public List<User> getAll();

    public User getById(String userid);

    public boolean save(User user);

    public boolean delete(String userid);
}
