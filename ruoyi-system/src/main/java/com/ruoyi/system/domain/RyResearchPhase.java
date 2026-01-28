package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科研阶段对象 ry_research_phase
 * 
 * @author ruoyi
 * @date 2026-01-28
 */
public class RyResearchPhase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 阶段ID */
    private Long phaseId;

    /** 关联课题ID */
    @Excel(name = "关联课题ID")
    private Long projectId;

    /** 阶段名称 */
    @Excel(name = "阶段名称")
    private String phaseName;

    /** 显示排序 */
    @Excel(name = "显示排序")
    private Long sortOrder;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "截止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

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

    public void setSortOrder(Long sortOrder) 
    {
        this.sortOrder = sortOrder;
    }

    public Long getSortOrder() 
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
