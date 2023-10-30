package com.example.controller;

import com.example.exception.BusinessException;
import com.example.exception.SystemException;
import com.example.util.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理器
//进行异常处理，后端异常时返回对应信息，后端就不会出现异常报错，前端也会收到异常消息
@Slf4j
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //添加异常句柄
    @ExceptionHandler(SystemException.class)
    public Res doSystemException(SystemException ex) {
        //记录日志
        log.info("系统错误，请更正！");
        //发送消息给运维
        //发送邮件给开发人员
        return new Res(ex.getCode(), null, ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Res doBusinessException(BusinessException ex) {
        //记录日志
        log.info("业务错误，请更正！");
        //发送消息给运维
        //发送邮件给开发人员
        return new Res(ex.getCode(), null, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Res doException(Exception ex) {
        //记录日志
        log.info("未知错误，检查数据库！");
        //发送消息给运维
        //发送邮件给开发人员
        return new Res(Code.SYSTEM_UNKNOWN_ERR, null,"系统繁忙，请稍后重试");
    }
}