package com.example.controller;

import com.example.annotation.SysLog;
import com.example.bean.SystemLog;
import com.example.service.SysLogService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试
 * @Auther: hp
 * @Date: 2019/10/8 14:47
 */
@RestController
public class HelloController {

    @Autowired
    private SysLogService sysLogService;
    /**
     * @return
     */
    @RequestMapping(value = "/")
    @SysLog(businessName = "首页模块", methodName = "index 方法", desc = "hi remark")
    public String hi() {
        return "hi";
    }

    /**
     * @return
     */
    @RequestMapping(value = "/hello")
    @SysLog(businessName = "欢迎模块", methodName = "hello 方法", desc = "hello remark")
    public String hello() {

        return "hello";
    }

    @RequestMapping("query")
    @SysLog(businessName = "日志模块", methodName = "query 方法", desc = "query log")
    public String query() {
        return new Gson().toJson(sysLogService.query());
    }
}
