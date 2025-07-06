package com.example.quartztest.listener;

import com.alibaba.fastjson.JSONObject;

import com.example.quartztest.entity.ScheduleJob;
import com.example.quartztest.jobManage.QuartzService;
import com.example.quartztest.task.MyJobAuto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.UUID;



/**
 * @Author :
 * @CreateTime :
 * @Description :定时任务初始化
 **/
@Configuration
public class ApplicationStartListener implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger log = LoggerFactory.getLogger(ApplicationStartListener.class);
    @Autowired
    private QuartzService quartzService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ScheduleJob job=new ScheduleJob();
        job.setId(1);//这个自己定，提前落表就好，可以改从表格中获取
        job.setJobId(UUID.randomUUID().toString().replaceAll("-",""));
        job.setClassName(MyJobAuto.class.getName());//注意,这里的路径请改成你自己的
        job.setCronExpression("0/3 * * * * ?");
        job.setJobName("AutoJob");
        job.setJobGroup("AutoJobGroup");
        job.setTriggerName("AutoJobTrigger");
        job.setTriggerGroup("AutoJobTriggerGroup");
        job.setDescription("AutoJob-随项目启动");
        //可以将任务跟数据库挂钩,做个任务管理模块,获取需要自启动的任务,记录各个参数等
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("testKey","测试即启动");
        job.setData(jsonObject);
        quartzService.addJob(job);


        //可以初始化多个，或者通过接口的add方法添加新的定时任务，要在task里面去新建job的实现
        /*JobEntity job1=new JobEntity();

        job1.setJobId(UUID.randomUUID().toString().replaceAll("-",""));

        job1.setClassName("com.example.quartztest.task.MyJobFirst");//注意,这里的路径请改成你自己的
        job1.setCronExpression("0/3 * * * * ?");
        job1.setJobName("MyJobFirst");
        job1.setJobGroup("MyJobFirstGroup");
        job1.setTriggerName("MyJobFirstTrigger");
        job1.setTriggerGroup("MyJobFirstTriggerGroup");
        job1.setDescription("MyJobFirst-随项目启动");
        //可以将任务跟数据库挂钩,做个任务管理模块,获取需要自启动的任务,记录各个参数等
        JSONObject jsonObject1=new JSONObject();
        jsonObject1.put("testKey","MyJobFirst测试即启动");
        job1.setData(jsonObject1);
        quartzService.addJob(job1);
        log.info("即触发定时任务已经开始执行.. .");
        log.info("************application已经启动完毕************");*/
    }


}