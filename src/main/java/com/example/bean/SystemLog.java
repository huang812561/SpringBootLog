package com.example.bean;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName: SystemLog
 * @Description: 系统日志表
 * @Auther: GuoqiangHuang
 * @Date: 2019/10/11 17:22
 */
@Entity
@Table(name = "system_log")
@Data
public class SystemLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String businessName;
    private String methodDesc;
    private String className;
    private String methodName;
    private String params;
    private long runTime;
    private String remark;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;


}
