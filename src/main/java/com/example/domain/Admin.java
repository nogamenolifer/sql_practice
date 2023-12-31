package com.example.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


//拿不到json数据，因为序列化以及驼峰命名规范导致的
//使用去拿不小写或者jsonproperty解决

//管理员
@Data
public class Admin {

    //管理员id
    @JsonProperty("AdminId")
    private String AdminId;

    //管理员密码
    @JsonProperty("Password")
    private String Password;
}
