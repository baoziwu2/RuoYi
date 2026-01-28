package com.ruoyi.research.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Research Task Object ry_research_task
 */
public class ResearchTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Task ID */
    private Long taskId;

    /** Phase ID */
    private Long phaseId;

    /** Task Name */
    private String taskName;

    /** Assigned User ID */
    private Long assignedUserId;

    /** Status (0 In Progress 1 Completed) */
    private String status;

    /** End Time */
    private Date endTime;

    /** Finish Time */
    private Date finishTime;

    /** Assigned User Name */
    private String assignedUserName;

    /** Project Name (For Display) */
    private String projectName;

    /** Phase Name (For Display) */
    private String phaseName;

    /** Is My Task Only */
    private boolean isMyTask;

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

    public String getAssignedUserName() {
        return assignedUserName;
    }

    public void setAssignedUserName(String assignedUserName) {
        this.assignedUserName = assignedUserName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public boolean getIsMyTask() {
        return isMyTask;
    }

    public void setIsMyTask(boolean isMyTask) {
        this.isMyTask = isMyTask;
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
            .append("assignedUserName", getAssignedUserName())
            .toString();
    }
}
