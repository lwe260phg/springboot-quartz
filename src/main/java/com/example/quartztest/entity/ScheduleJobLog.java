package com.example.quartztest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 定时任务日志
 * </p>
 *
 * @author HZW
 * @since 2021-11-30
 */
@TableName("eb_schedule_job_log")
public class ScheduleJobLog implements Serializable {

    private static final long serialVersionUID=1L;

   // @ApiModelProperty(value = "任务日志id")
    @TableId(value = "log_id", type = IdType.AUTO)
    private Integer logId;

    //@ApiModelProperty(value = "任务id")
    private Integer jobId;

   // @ApiModelProperty(value = "spring bean名称")
    private String beanName;

    //@ApiModelProperty(value = "方法名")
    private String methodName;

    //@ApiModelProperty(value = "参数")
    private String params;

   // @ApiModelProperty(value = "任务状态    0：成功    1：失败")
    private Integer status;

    //@ApiModelProperty(value = "失败信息")
    private String error;

   // @ApiModelProperty(value = "耗时(单位：毫秒)")
    private Integer times;

    //@ApiModelProperty(value = "创建时间")
    private Date createTime;


    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
