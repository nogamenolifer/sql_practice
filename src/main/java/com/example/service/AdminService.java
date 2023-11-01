package com.example.service;

import com.example.domain.Admin;
import com.example.domain.User;

import java.util.List;

public interface AdminService {

    boolean Login(Admin admin);

    List<User> getAll();

    User getById(String userid);

    boolean save(User user);

    boolean delete(String userid);
}
