package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科研课题对象 ry_research_project
 * 
 * @author ruoyi
 * @date 2026-01-28
 */
public class RyResearchProject extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 课题ID */
    private Long projectId;

    /** 课题名称 */
    @Excel(name = "课题名称")
    private String projectName;

    /** 课题描述 */
    @Excel(name = "课题描述")
    private String description;

    /** 申请人ID */
    @Excel(name = "申请人ID")
    private Long applicantId;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "截止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 状态（0待审批 1已立项 2已驳回） */
    @Excel(name = "状态", readConverterExp = "0=待审批,1=已立项,2=已驳回")
    private String status;

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
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
                .toString();
    }
}
