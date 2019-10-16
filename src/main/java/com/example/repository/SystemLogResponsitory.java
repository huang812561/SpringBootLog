package com.example.repository;

import com.example.bean.SystemLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: SystemLogResponsitory
 * @Description: 系统日志
 * @Auther: GuoqiangHuang
 * @Date: 2019/10/11 18:18
 */
public interface SystemLogResponsitory extends CrudRepository<SystemLog, Long> {
}
