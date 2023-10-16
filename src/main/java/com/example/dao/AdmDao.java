package com.example.dao;

import com.example.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdmDao {

    @Select("select * form admin_info where Admin_Id = #{AdminId}")
    public Admin getById(Integer AdminId);
}
