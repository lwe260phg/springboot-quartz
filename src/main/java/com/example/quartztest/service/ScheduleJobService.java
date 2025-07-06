package com.example.quartztest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.quartztest.entity.ScheduleJob;


public interface ScheduleJobService extends IService<ScheduleJob> {

    /**
     * 自动删除日志
     */
    void autoDeleteLog();
}
