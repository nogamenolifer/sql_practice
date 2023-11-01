package com.example.dao;

import com.example.domain.Admin;
import com.example.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    @Select("select * from user_info where userid = #{userid}")
    public User getByUserid(String userid);

    @Insert("insert into user_info (userid, password, gender, number, interest, status) " +
            "values(#{userid}, #{password}, #{gender}, #{number}, #{interest}, #{status})")
    public int save(User user);

    @Delete("delete from user_info where userid = #{userid}")
    public int delete(String userid);
}
