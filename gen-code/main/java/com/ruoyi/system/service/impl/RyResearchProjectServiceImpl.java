package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RyResearchProjectMapper;
import com.ruoyi.system.domain.RyResearchProject;
import com.ruoyi.system.service.IRyResearchProjectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 科研课题Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-28
 */
@Service
public class RyResearchProjectServiceImpl implements IRyResearchProjectService 
{
    @Autowired
    private RyResearchProjectMapper ryResearchProjectMapper;

    /**
     * 查询科研课题
     * 
     * @param projectId 科研课题主键
     * @return 科研课题
     */
    @Override
    public RyResearchProject selectRyResearchProjectByProjectId(Long projectId)
    {
        return ryResearchProjectMapper.selectRyResearchProjectByProjectId(projectId);
    }

    /**
     * 查询科研课题列表
     * 
     * @param ryResearchProject 科研课题
     * @return 科研课题
     */
    @Override
    public List<RyResearchProject> selectRyResearchProjectList(RyResearchProject ryResearchProject)
    {
        return ryResearchProjectMapper.selectRyResearchProjectList(ryResearchProject);
    }

    /**
     * 新增科研课题
     * 
     * @param ryResearchProject 科研课题
     * @return 结果
     */
    @Override
    public int insertRyResearchProject(RyResearchProject ryResearchProject)
    {
        ryResearchProject.setCreateTime(DateUtils.getNowDate());
        return ryResearchProjectMapper.insertRyResearchProject(ryResearchProject);
    }

    /**
     * 修改科研课题
     * 
     * @param ryResearchProject 科研课题
     * @return 结果
     */
    @Override
    public int updateRyResearchProject(RyResearchProject ryResearchProject)
    {
        ryResearchProject.setUpdateTime(DateUtils.getNowDate());
        return ryResearchProjectMapper.updateRyResearchProject(ryResearchProject);
    }

    /**
     * 批量删除科研课题
     * 
     * @param projectIds 需要删除的科研课题主键
     * @return 结果
     */
    @Override
    public int deleteRyResearchProjectByProjectIds(String projectIds)
    {
        return ryResearchProjectMapper.deleteRyResearchProjectByProjectIds(Convert.toStrArray(projectIds));
    }

    /**
     * 删除科研课题信息
     * 
     * @param projectId 科研课题主键
     * @return 结果
     */
    @Override
    public int deleteRyResearchProjectByProjectId(Long projectId)
    {
        return ryResearchProjectMapper.deleteRyResearchProjectByProjectId(projectId);
    }
}
