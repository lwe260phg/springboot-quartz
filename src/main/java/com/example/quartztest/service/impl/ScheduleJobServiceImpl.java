package com.example.quartztest.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.quartztest.dao.ScheduleJobDao;
import com.example.quartztest.entity.ScheduleJob;
import com.example.quartztest.service.ScheduleJobService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @Author :
 * @CreateTime :
 * @Description :定时任务初始化
 **/
@Service
public class ScheduleJobServiceImpl extends ServiceImpl<ScheduleJobDao, ScheduleJob> implements ScheduleJobService {

    @Resource
    private ScheduleJobDao dao;

}

