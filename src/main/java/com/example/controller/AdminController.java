package com.example.controller;


import com.example.domain.Admin;
import com.example.domain.User;
import com.example.service.AdminService;
import com.example.util.Res;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@ApiOperation(value = "管理员相关的操作")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    /**
     * @param admin
     * @return boolean
     */
    //拿不到json数据，因为序列化以及驼峰命名规范导致的
    //使用去拿不小写或者jsonproperty解决
    //requestbody 默认为json支持，无法自动传入类
    @ApiOperation(value = "管理员登录",
            notes = "输入管理员对象，检验是否存在此管理员",
            httpMethod = "POST",
            tags = "登录"
    )
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

    /**
     * @return boolean
     */
    @ApiOperation(value = "管理员登出",
            notes = "登出当前管理员",
            httpMethod = "POST",
            tags = "登出"
    )
    @PostMapping("/logout")
    public Res logout()
    {
        return new Res();
    }

    /**
     * @return list<user></>
     */
    @ApiOperation(value = "查询全部用户数据",
            httpMethod = "GET",
            tags = "查询全部"
    )
    @GetMapping
    public Res getAll() {
        List<User> users = adminService.getAll();
        Integer code = users != null ? Code.USER_GET_ALL_OK : Code.USER_GET_ALL_ERR;
        String msg = users != null ? "" : "数据查询错误，请重试";
        return new Res(users, code, msg);
    }

    /**
     * @param user
     * @return boolean
     */
    @ApiOperation(value = "新建用户",
            httpMethod = "POST",
            tags = "增加"
    )
    @PostMapping("/save")
    public Res save(@RequestBody User user) {
        log.info("进入添加用户控制层");
        boolean flag = adminService.save(user);
        return new Res(flag, flag ? Code.USER_SAVE_OK : Code.USER_SAVE_ERR);
    }


    /**
     * @param userid
     * @return boolean
     */
    @ApiOperation(value = "删除用户",
            httpMethod = "GET",
            tags = "删除"
    )
    @DeleteMapping("/{userid}")
    public Res delete(@PathVariable String userid) {
        log.info("进入删除用户控制层");
        boolean flag = adminService.delete(userid);
        return new Res(flag, flag ? Code.USER_DELETE_OK : Code.USER_DELETE_ERR);
    }

    /**
     * @param userid
     * @return user
     */
    @ApiOperation(value = "查询单个用户数据",
            httpMethod = "GET",
            tags = "查询"
    )
    @GetMapping("/{userid}")
    public Res getById(@PathVariable String userid) {
        log.info("进入单个查询控制层");
        User user = adminService.getById(userid);
        Integer code = user != null ? Code.USER_GET_OK : Code.USER_GET_ERR;
        String msg = user != null ? "" : "数据查询错误";
        return new Res(user, code, msg);
    }

}
