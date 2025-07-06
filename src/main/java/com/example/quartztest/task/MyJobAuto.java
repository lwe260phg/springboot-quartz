package com.example.quartztest.task;

/**
 * @Author : JCccc
 * @CreateTime : 2020/3/21
 * @Description :
 **/
import com.alibaba.fastjson.JSONObject;
import com.example.quartztest.config.ScheduleConstants;
import com.example.quartztest.entity.ScheduleJobLog;
import com.example.quartztest.service.ScheduleJobLogService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@DisallowConcurrentExecution
public class MyJobAuto implements Job {
    private static Logger log = LoggerFactory.getLogger(MyJobAuto.class);
    private void before() {

        log.info("******MyJobFirst任务开始执行******");
    }
    @Autowired
    ScheduleJobLogService scheduleJobLogService;
    @Override
    public void execute(JobExecutionContext context) {
        before();
        //定时任务处理的业务逻辑
        //...
        //...

        ScheduleJobLog jobLog = new ScheduleJobLog();
        jobLog.setJobId(1);
        jobLog.setBeanName("MyJobAuto");
        jobLog.setCreateTime(new Date());
        jobLog.setStatus(ScheduleConstants.NORMAL);
        jobLog.setMethodName("execute");
        String name = context.getJobDetail().getKey().getName();
        log.info("******MyJobAuto任务[{}]正在执行******",name);
        JobDataMap jobDataMap=context.getJobDetail().getJobDataMap();
        JSONObject jsonObject = (JSONObject) jobDataMap.get("myValue");
        log.info("MyJobAuto任务[{}]携带的参数[{}]",name,jsonObject.toString());

        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("当前时间[{}],MyJobAuto任务[{}]的线程名[{}]",time,name,Thread.currentThread().getName());
        //scheduleJobLogService.save(jobLog);
        scheduleJobLogService.test();
        after();
    }
    private void after() {

        log.info("******MyJobFirst任务执行结束******");
    }
}