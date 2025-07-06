package com.example.quartztest.config;

import com.example.quartztest.entity.ScheduleJob;

/**
 * 定时任务事件
 */

public class ScheduleJobEvent {

	private final ScheduleJob scheduleJob;

	public ScheduleJobEvent(ScheduleJob scheduleJob) {
		this.scheduleJob = scheduleJob;
	}

	public ScheduleJob getScheduleJob() {
		return scheduleJob;
	}
}
