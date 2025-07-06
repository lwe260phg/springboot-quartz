package com.example.quartztest.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.quartztest.config.ScheduleConstants;
import com.example.quartztest.dao.ScheduleJobLogDao;
import com.example.quartztest.entity.ScheduleJobLog;
import com.example.quartztest.service.ScheduleJobLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author HZW
* @description ScheduleJobLogServiceImpl 接口实现
* @date 2021-11-30
*/
@Service
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogDao, ScheduleJobLog> implements ScheduleJobLogService {

    @Resource
    private ScheduleJobLogDao dao;

    /**
     * 自动删除日志
     */
    @Override
    public void autoDeleteLog() {
        String beforeDate = DateUtil.offsetDay(new Date(), -9).toString("yyyy-MM-dd");
        UpdateWrapper<ScheduleJobLog> wrapper = Wrappers.update();
        wrapper.lt("create_time", beforeDate);
        dao.delete(wrapper);
    }

    @Override
    public void test() {
        System.out.printf("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        ScheduleJobLog jobLog = new ScheduleJobLog();
        try {
            jobLog.setJobId(1);
            jobLog.setBeanName("MyJobAuto");
            jobLog.setCreateTime(new Date());
            jobLog.setMethodName("execute");
            jobLog.setStatus(0);
            int a = 1/0;
        }catch (Exception e){
            log.error("任务执行失败，任务ID：" + 1, e);
            jobLog.setError(e.getMessage());
            jobLog.setStatus(1);
        }finally {
            save(jobLog);
        }
    }
}

