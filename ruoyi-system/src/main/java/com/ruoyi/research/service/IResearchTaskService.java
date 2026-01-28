package com.ruoyi.research.service;

import java.util.List;
import com.ruoyi.research.domain.ResearchTask;

/**
 * Research Task Service Interface
 */
public interface IResearchTaskService 
{
    public ResearchTask selectTaskById(Long taskId);
    public List<ResearchTask> selectTaskList(ResearchTask researchTask);
    public int insertTask(ResearchTask researchTask);
    public int updateTask(ResearchTask researchTask);
    public int deleteTaskByIds(String ids);
}
