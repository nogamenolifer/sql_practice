package com.example.controller;


import com.example.domain.Admin;
import com.example.domain.User;
import com.example.service.AdminService;
import com.example.util.Res;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    /**
     * @param admin
     * @return
     */
    //拿不到json数据，因为序列化以及驼峰命名规范导致的
    //使用去拿不小写或者jsonproperty解决
    //requestbody 默认为json支持，无法自动传入类
    @PostMapping
    public Res login(@RequestBody Admin admin) {
        System.out.println(admin);
        log.info("进入管理控制层");
        boolean flag  = adminService.Login(admin);
        if (flag) {
            return new Res(Code.ADMIN_LOGIN_OK, "登陆成功");
        } else {
            return new Res(Code.ADMIN_LOGIN_ERR, "密码错误，请检查用户名密码是否正确");
        }
    }

    @PostMapping("/logout")
    public Res logout()
    {
        return new Res();
    }

    @GetMapping
    public Res getAll() {
        List<User> users = adminService.getAll();
        Integer code = users != null ? Code.USER_GET_ALL_OK : Code.USER_GET_ALL_ERR;
        String msg = users != null ? "" : "数据查询错误，请重试";
        return new Res(users, code, msg);
    }

    @GetMapping("/{id}")
    public Res getById() {
        return new Res();
    }

}
