package com.ruoyi.research.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.research.mapper.ResearchProjectMapper;
import com.ruoyi.research.domain.ResearchProject;
import com.ruoyi.research.service.IResearchProjectService;
import com.ruoyi.common.core.text.Convert;

/**
 * Research Project Service Implementation
 */
@Service
public class ResearchProjectServiceImpl implements IResearchProjectService 
{
    @Autowired
    private ResearchProjectMapper researchProjectMapper;

    /**
     * Query Project By ID
     * 
     * @param projectId Project ID
     * @return Project
     */
    @Override
    public ResearchProject selectProjectById(Long projectId)
    {
        return researchProjectMapper.selectProjectById(projectId);
    }

    /**
     * Query Project Tree By ID
     * 
     * @param projectId Project ID
     * @return Project
     */
    @Override
    public ResearchProject selectProjectTreeById(Long projectId)
    {
        return researchProjectMapper.selectProjectTreeById(projectId);
    }

    /**
     * Query Project List
     * 
     * @param researchProject Project
     * @return Project Collection
     */
    @Override
    public List<ResearchProject> selectProjectList(ResearchProject researchProject)
    {
        return researchProjectMapper.selectProjectList(researchProject);
    }

    /**
     * Add Project
     * 
     * @param researchProject Project
     * @return Result
     */
    @Override
    public int insertProject(ResearchProject researchProject)
    {
        researchProject.setCreateTime(DateUtils.getNowDate());
        if (researchProject.getStatus() == null) {
            researchProject.setStatus("0");
        }
        return researchProjectMapper.insertProject(researchProject);
    }

    /**
     * Update Project
     * 
     * @param researchProject Project
     * @return Result
     */
    @Override
    public int updateProject(ResearchProject researchProject)
    {
        researchProject.setUpdateTime(DateUtils.getNowDate());
        return researchProjectMapper.updateProject(researchProject);
    }

    /**
     * Batch Delete Project
     * 
     * @param ids Project IDs
     * @return Result
     */
    @Override
    public int deleteProjectByIds(String ids)
    {
        return researchProjectMapper.deleteProjectByIds(Convert.toStrArray(ids));
    }

    /**
     * Delete Project by ID
     * 
     * @param projectId Project ID
     * @return Result
     */
    @Override
    public int deleteProjectById(Long projectId)
    {
        return researchProjectMapper.deleteProjectById(projectId);
    }
}
