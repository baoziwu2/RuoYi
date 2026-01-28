package com.ruoyi.research.service;

import java.util.List;
import com.ruoyi.research.domain.ResearchProject;

/**
 * Research Project Service Interface
 */
public interface IResearchProjectService 
{
    /**
     * Query Project By ID
     * 
     * @param projectId Project ID
     * @return Project
     */
    public ResearchProject selectProjectById(Long projectId);

    /**
     * Query Project Tree By ID
     * 
     * @param projectId Project ID
     * @return Project
     */
    public ResearchProject selectProjectTreeById(Long projectId);

    /**
     * Query Project List
     * 
     * @param researchProject Project
     * @return Project Collection
     */
    public List<ResearchProject> selectProjectList(ResearchProject researchProject);

    /**
     * Add Project
     * 
     * @param researchProject Project
     * @return Result
     */
    public int insertProject(ResearchProject researchProject);

    /**
     * Update Project
     * 
     * @param researchProject Project
     * @return Result
     */
    public int updateProject(ResearchProject researchProject);

    /**
     * Batch Delete Project
     * 
     * @param ids Project IDs
     * @return Result
     */
    public int deleteProjectByIds(String ids);

    /**
     * Delete Project by ID
     * 
     * @param projectId Project ID
     * @return Result
     */
    public int deleteProjectById(Long projectId);
}
