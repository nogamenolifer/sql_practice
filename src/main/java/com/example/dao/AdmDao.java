package com.example.dao;

import com.example.domain.Admin;
import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface AdmDao {

    @Select("select * from admin_info where adminid = #{AdminId}")
    public Admin getById(String AdminId);

    @Select("select * from user_info")
    public List<User> getAll();
}
