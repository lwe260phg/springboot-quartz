package com.example.quartztest.jobManage;

import com.alibaba.fastjson.JSONObject;
import com.example.quartztest.entity.ScheduleJob;

/**
 * @Author :
 * @CreateTime :
 * @Description :定时任务方法
 **/
public interface QuartzService {

    /**
     * 创建Job
     * @param job
     */
    Boolean addJob(ScheduleJob job);

    /**
     * 执行Job
     * @param job
     */
    Boolean runJob(ScheduleJob job);

    /**
     * 修改Job
     * @param job
     */
    Boolean updateJob(ScheduleJob job);

    /**
     * 暂定Job
     * @param job
     */
    Boolean pauseJob(ScheduleJob job);

    /**
     * 唤醒Job
     * @param job
     */
    Boolean resumeJob(ScheduleJob job);

    /**
     * 删除Job
     * @param job
     */
    Boolean deleteJob(ScheduleJob job);

    /**
     * 获取Job
     * @param job
     */
    JSONObject queryJob(ScheduleJob job);

}