package com.ruoyi.research.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Research Phase Object ry_research_phase
 */
public class ResearchPhase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Phase ID */
    private Long phaseId;

    /** Project ID */
    private Long projectId;

    /** Phase Name */
    private String phaseName;

    /** Sort Order */
    private Integer sortOrder;

    /** End Time */
    private Date endTime;

    /** Project Name (Display) */
    private String projectName;

    /** Task List */
    private java.util.List<ResearchTask> tasks;

    public void setPhaseId(Long phaseId) 
    {
        this.phaseId = phaseId;
    }

    public Long getPhaseId() 
    {
        return phaseId;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setPhaseName(String phaseName) 
    {
        this.phaseName = phaseName;
    }

    public String getPhaseName() 
    {
        return phaseName;
    }
    public void setSortOrder(Integer sortOrder) 
    {
        this.sortOrder = sortOrder;
    }

    public Integer getSortOrder() 
    {
        return sortOrder;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public java.util.List<ResearchTask> getTasks() {
        return tasks;
    }

    public void setTasks(java.util.List<ResearchTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("phaseId", getPhaseId())
            .append("projectId", getProjectId())
            .append("phaseName", getPhaseName())
            .append("sortOrder", getSortOrder())
            .append("endTime", getEndTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
