package com.example.quartztest.config;

import com.example.quartztest.entity.ScheduleJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

/**
 * 该类将会被org.springframework.scheduling.quartz.SpringBeanJobFactory 实例化
 * 并使@Autowired 生效
 * @Author 指缝de阳光
 * @Date 2021/11/30 12:10
 * @Version 1.0
 */
@DisallowConcurrentExecution
public class QuartzJob implements Job {

    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * 任务调度参数key
     */
    public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        Object o = mergedJobDataMap.get(JOB_PARAM_KEY);
        ScheduleJob sysJob = (ScheduleJob) o;
        publisher.publishEvent(new ScheduleJobEvent(sysJob));
    }
}
