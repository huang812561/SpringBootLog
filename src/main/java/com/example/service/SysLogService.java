package com.example.service;

import com.example.bean.SystemLog;
import com.example.repository.SystemLogResponsitory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: SysLogService
 * @Description: TODO
 * @Auther: GuoqiangHuang
 * @Date: 2019/10/11 18:16
 */
@Service
@Slf4j
public class SysLogService {

    @Resource
    private SystemLogResponsitory systemLogResponsitory;

    /**
     * 保存系统日志
     * @param sysLogBO
     */
    public void saveLog(SystemLog sysLogBO){
        systemLogResponsitory.save(sysLogBO);
    }

    /**
     * 查询所有系统日志
     * @return
     */
    public List<SystemLog> query() {
        return (List<SystemLog>) systemLogResponsitory.findAll();
    }
}
