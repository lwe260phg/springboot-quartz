package com.example.quartztest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.quartztest.entity.ScheduleJobLog;

/**
* @author HZW
* @description ScheduleJobLogService 接口
* @date 2021-11-30
*/
public interface ScheduleJobLogService extends IService<ScheduleJobLog> {

    /**
     * 自动删除日志
     */
    void autoDeleteLog();
    void test();
}