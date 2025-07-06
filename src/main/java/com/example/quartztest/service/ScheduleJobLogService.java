package com.example.quartztest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.quartztest.entity.ScheduleJobLog;

/**
 * @Author :
 * @CreateTime :
 * @Description :ScheduleJobLog接口
 **/
public interface ScheduleJobLogService extends IService<ScheduleJobLog> {

    /**
     * 自动删除日志
     */
    void autoDeleteLog();
    void test();
}