package com.example.quartztest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;


/**
 * @Author :
 * @CreateTime :
 * @Description :定时任务日志
 **/
@TableName("schedule_job_log")
public class ScheduleJobLog implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 任务日志id,唯一id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //@ApiModelProperty(value = "任务id")
    private String jobId;

   // @ApiModelProperty(value = "spring bean名称")
    private String beanName;

    //@ApiModelProperty(value = "方法名")
    private String methodName;

    //@ApiModelProperty(value = "参数")
    private String params;

   // @ApiModelProperty(value = "执行状态    0：失败   1：成功")
    private Integer status;

    //@ApiModelProperty(value = "失败信息")
    private String error;

   // @ApiModelProperty(value = "耗时(单位：毫秒)")
    private Integer times;

    //@ApiModelProperty(value = "创建时间")
    private Date createTime;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
