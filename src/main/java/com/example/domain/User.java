package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

//用户
public class User {

    //用户id
    @JsonProperty("userid")
    private String userid;

    //用户密码
    @JsonProperty("password")
    private String password;

    //用户性别
    @JsonProperty("gender")
    private String gender;

    //用户手机号
    @JsonProperty("number")
    private String number;

    //用户兴趣爱好
    @JsonProperty("interest")
    private String interest;

    //用户状态
    @JsonProperty("status")
    private String status;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userid, user.userid) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, password, gender, number, interest, status);
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", number='" + number + '\'' +
                ", interest='" + interest + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
