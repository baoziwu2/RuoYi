package com.ruoyi.research.mapper;

import java.util.List;
import com.ruoyi.research.domain.ResearchTask;

/**
 * Research Task Mapper Interface
 */
public interface ResearchTaskMapper 
{
    public ResearchTask selectTaskById(Long taskId);
    public List<ResearchTask> selectTaskList(ResearchTask researchTask);
    public int insertTask(ResearchTask researchTask);
    public int updateTask(ResearchTask researchTask);
    public int deleteTaskById(Long taskId);
    public int deleteTaskByIds(String[] taskIds);
}
