package com.example.aop;

import com.example.annotation.SysLog;
import com.example.bean.SystemLog;
import com.example.service.SysLogService;
import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: AspectSystemLog
 * @Description: 系统日志切面
 * @Auther: GuoqiangHuang
 * @Date: 2019/10/11 16:28
 */
@Aspect
@Component
@Order(1)
public class AspectSystemLog {

    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.example.annotation.SysLog)")
    public void logPointCut(){};

    @Around(value = "logPointCut()")
    public void arround(ProceedingJoinPoint joinPoint){
        try {
            long beginTime = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long time = System.currentTimeMillis() - beginTime;
            saveLog(joinPoint, time);
        } catch (Exception e) {
        } catch (Throwable throwable) {
        }
    }

    /**
     * 保存系统日志入库
     * @param joinPoint
     * @param time
     */
    public void saveLog(ProceedingJoinPoint joinPoint, long time){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        SystemLog sysLogBO = new SystemLog();
        sysLogBO.setRunTime(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sysLogBO.setCreateDate(new Date());
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if(sysLog != null){
            //注解上的描述
            sysLogBO.setBusinessName(sysLog.businessName());
            sysLogBO.setMethodDesc(sysLog.methodName());
            sysLogBO.setRemark(sysLog.desc());
        }
        //请求的 类名、方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = method.getName();
        sysLogBO.setClassName(className);
        sysLogBO.setMethodName(methodName);
        //请求的参数
        Object[] args = joinPoint.getArgs();
        try{
            List<String> list = new ArrayList<String>();
            for (Object o : args) {
                list.add(new Gson().toJson(o));
            }
            sysLogBO.setParams(list.toString());
        }catch (Exception e){ }
        sysLogService.saveLog(sysLogBO);
    }
}
