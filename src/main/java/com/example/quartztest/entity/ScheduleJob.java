package com.example.quartztest.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;


/**
 * @Author :
 * @CreateTime :
 * @Description :定时任务
 **/
@TableName("schedule_job")
public class ScheduleJob implements Serializable {
    private static final long serialVersionUID=1L;
    @TableId(value = "job_id", type = IdType.AUTO)
    private Integer id;
    /**
     * 任务唯一id
     */
    private String jobId;
    /**
     * 定时任务示例的 class路径
     */
    private String className;
    /**
     *cron表达式
     */
    private String cronExpression;
    /**
     *定时任务名称
     */
    private String jobName;
    /**
     *所属组
     */
    private String jobGroup;
    /**
     *触发器名称
     **/
    private String triggerName;
    /**
     *触发器组
     */
    private String triggerGroup;
    /**
     *备注
     */
    private String description;
    /**
     *携带参数
     */
    private JSONObject data;

    /**
     * 是否有效
     */
    private Boolean pauseStatus;
    /**
     * 是否取消
     */
    private Boolean deleteStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


    @Override
    public String toString() {
        return "JobEntity{" +
                "jobId='" + jobId + '\'' +
                ", className='" + className + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", triggerGroup='" + triggerGroup + '\'' +
                ", description='" + description + '\'' +
                ", data=" + data +
                ", pauseStatus=" + pauseStatus +
                ", deleteStatus=" + deleteStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public Boolean getPauseStatus() {
        return pauseStatus;
    }

    public void setPauseStatus(Boolean pauseStatus) {
        this.pauseStatus = pauseStatus;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}