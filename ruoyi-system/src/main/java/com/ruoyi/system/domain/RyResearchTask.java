package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科研任务对象 ry_research_task
 * 
 * @author ruoyi
 * @date 2026-01-28
 */
public class RyResearchTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long taskId;

    /** 关联阶段ID */
    @Excel(name = "关联阶段ID")
    private Long phaseId;

    /** 任务内容 */
    @Excel(name = "任务内容")
    private String taskName;

    /** 指派执行人ID */
    @Excel(name = "指派执行人ID")
    private Long assignedUserId;

    /** 状态（0进行中 1已完成） */
    @Excel(name = "状态", readConverterExp = "0=进行中,1=已完成")
    private String status;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "截止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 实际完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "实际完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishTime;

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }

    public void setPhaseId(Long phaseId) 
    {
        this.phaseId = phaseId;
    }

    public Long getPhaseId() 
    {
        return phaseId;
    }

    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskName() 
    {
        return taskName;
    }

    public void setAssignedUserId(Long assignedUserId) 
    {
        this.assignedUserId = assignedUserId;
    }

    public Long getAssignedUserId() 
    {
        return assignedUserId;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    public void setFinishTime(Date finishTime) 
    {
        this.finishTime = finishTime;
    }

    public Date getFinishTime() 
    {
        return finishTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("phaseId", getPhaseId())
            .append("taskName", getTaskName())
            .append("assignedUserId", getAssignedUserId())
            .append("status", getStatus())
            .append("endTime", getEndTime())
            .append("finishTime", getFinishTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
