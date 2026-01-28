package com.ruoyi.research.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Research Project Object ry_research_project
 */
public class ResearchProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Project ID */
    private Long projectId;

    /** Project Name */
    private String projectName;

    /** Description */
    private String description;

    /** Applicant ID */
    private Long applicantId;

    /** End Time */
    private Date endTime;

    /** Status (0 Reviewing 1 Approved 2 Rejected) */
    private String status;
    
    /** Applicant Name (User Name) */
    private String applicantName;

    /** Phase List */
    private java.util.List<ResearchPhase> phases;

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setApplicantId(Long applicantId) 
    {
        this.applicantId = applicantId;
    }

    public Long getApplicantId() 
    {
        return applicantId;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public java.util.List<ResearchPhase> getPhases() {
        return phases;
    }

    public void setPhases(java.util.List<ResearchPhase> phases) {
        this.phases = phases;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectId", getProjectId())
            .append("projectName", getProjectName())
            .append("description", getDescription())
            .append("applicantId", getApplicantId())
            .append("endTime", getEndTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("applicantName", getApplicantName())
            .toString();
    }
}
