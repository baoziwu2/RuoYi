package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.RyResearchProject;

/**
 * 科研课题Service接口
 * 
 * @author ruoyi
 * @date 2026-01-28
 */
public interface IRyResearchProjectService 
{
    /**
     * 查询科研课题
     * 
     * @param projectId 科研课题主键
     * @return 科研课题
     */
    public RyResearchProject selectRyResearchProjectByProjectId(Long projectId);

    /**
     * 查询科研课题列表
     * 
     * @param ryResearchProject 科研课题
     * @return 科研课题集合
     */
    public List<RyResearchProject> selectRyResearchProjectList(RyResearchProject ryResearchProject);

    /**
     * 新增科研课题
     * 
     * @param ryResearchProject 科研课题
     * @return 结果
     */
    public int insertRyResearchProject(RyResearchProject ryResearchProject);

    /**
     * 修改科研课题
     * 
     * @param ryResearchProject 科研课题
     * @return 结果
     */
    public int updateRyResearchProject(RyResearchProject ryResearchProject);

    /**
     * 批量删除科研课题
     * 
     * @param projectIds 需要删除的科研课题主键集合
     * @return 结果
     */
    public int deleteRyResearchProjectByProjectIds(String projectIds);

    /**
     * 删除科研课题信息
     * 
     * @param projectId 科研课题主键
     * @return 结果
     */
    public int deleteRyResearchProjectByProjectId(Long projectId);
}
