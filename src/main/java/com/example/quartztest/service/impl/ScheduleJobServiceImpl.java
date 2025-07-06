package com.example.quartztest.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.quartztest.config.ScheduleConstants;
import com.example.quartztest.config.ScheduleManager;
import com.example.quartztest.dao.ScheduleJobDao;
import com.example.quartztest.entity.ScheduleJob;
import com.example.quartztest.service.ScheduleJobService;
import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleJobServiceImpl extends ServiceImpl<ScheduleJobDao, ScheduleJob> implements ScheduleJobService {

    @Resource
    private ScheduleJobDao dao;

    @Autowired
    private ScheduleManager scheduleManager;

    /**
     * 项目启动时，初始化定时器
     */
    //@PostConstruct
    public void init() {
        getAll().forEach(scheduleJob -> {
            CronTrigger trigger = scheduleManager.getCronTrigger(scheduleJob);
            // 如果定时任务不存在，则创建定时任务
            if (trigger == null) {
                scheduleManager.createScheduleJob(scheduleJob);
            } else if (ScheduleConstants.NORMAL.equals(scheduleJob.getStatus())) {
                scheduleManager.resumeJob(scheduleJob);
            } else if (ScheduleConstants.PAUSE.equals(scheduleJob.getStatus())) {
                scheduleManager.pauseJob(scheduleJob);
            }
        });
    }

    /**
     * 获取所有的job
     * @return List<ScheduleJob>
     */
    private List<ScheduleJob> getAll() {
        LambdaQueryWrapper<ScheduleJob> lqw = Wrappers.lambdaQuery();
//        lqw.eq(ScheduleJob::getDelte, false);
        return dao.selectList(lqw);
    }

    /**
     * 自动删除日志
     * 只保留十天的日志
     */
    @Override
    public void autoDeleteLog() {
        String beforeDate = DateUtil.offsetDay(new Date(), -9).toString("yyyy-MM-dd");
        UpdateWrapper<ScheduleJob> wrapper = Wrappers.update();
        wrapper.lt("create_time", beforeDate);
        dao.delete(wrapper);
    }
}

