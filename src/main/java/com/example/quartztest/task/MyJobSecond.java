package com.example.quartztest.task; /**
 * @Author :
 * @CreateTime :
 * @Description :
 **/

import com.alibaba.fastjson.JSONObject;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component("MyJobSecond")
public class MyJobSecond implements Job{

    private static Logger log = LoggerFactory.getLogger(MyJobSecond.class);

    @Override
    public void execute(JobExecutionContext context) {
        //定时任务处理的业务逻辑
        //...
        //...

        String name = context.getJobDetail().getKey().getName();
        log.info("******MyJobSecond任务[{}]正在执行******",name);
        JobDataMap jobDataMap=context.getJobDetail().getJobDataMap();
        JSONObject jsonObject = (JSONObject) jobDataMap.get("myValue");
        log.info("MyJobSecond任务[{}]携带的参数[{}]",name,jsonObject.toString());

        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("当前时间[{}],MyJobSecond任务[{}]的线程名[{}]",time,name,Thread.currentThread().getName());
    }

}