package com.example.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @ClassName: DruidStatFilter
 * @Description: 配置监控拦截器, druid监控拦截器
 * @Auther: GuoqiangHuang
 * @Date: 2019/10/12 16:58
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
        })
public class DruidStatFilter extends WebStatFilter {
}
