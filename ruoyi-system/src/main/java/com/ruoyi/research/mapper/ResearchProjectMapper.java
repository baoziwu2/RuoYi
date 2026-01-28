package com.ruoyi.research.mapper;

import java.util.List;
import com.ruoyi.research.domain.ResearchProject;

/**
 * Research Project Mapper Interface
 */
public interface ResearchProjectMapper 
{
    /**
     * Query Project By ID
     * 
     * @param projectId Project ID
     * @return Project
     */
    public ResearchProject selectProjectById(Long projectId);

    /**
     * Query Project Tree by ID
     * 
     * @param projectId Project ID
     * @return Project with nested phases and tasks
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
     * Delete Project by ID
     * 
     * @param projectId Project ID
     * @return Result
     */
    public int deleteProjectById(Long projectId);

    /**
     * Batch Delete Project
     * 
     * @param projectIds Project IDs
     * @return Result
     */
    public int deleteProjectByIds(String[] projectIds);
}
