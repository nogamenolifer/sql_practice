package com.example.dao;

import com.example.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

@Mapper
public interface AdmDao {

    @Select("select * from admin_info where adminid = #{AdminId}")
    public Admin getById(String AdminId);
}
