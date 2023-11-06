package com.example.service;

import com.example.domain.Admin;
import com.example.domain.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public interface AdminService {

    boolean Login(Admin admin);

    List<User> getAll();

    User getById(String userid);

    boolean save(User user);

    boolean delete(String userid);

    boolean update(User user);
}
