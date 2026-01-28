package com.ruoyi.research.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.research.mapper.ResearchTaskMapper;
import com.ruoyi.research.domain.ResearchTask;
import com.ruoyi.research.service.IResearchTaskService;
import com.ruoyi.common.core.text.Convert;

/**
 * Research Task Service Implementation
 */
@Service
public class ResearchTaskServiceImpl implements IResearchTaskService 
{
    @Autowired
    private ResearchTaskMapper researchTaskMapper;

    @Override
    public ResearchTask selectTaskById(Long taskId)
    {
        return researchTaskMapper.selectTaskById(taskId);
    }

    @Override
    public List<ResearchTask> selectTaskList(ResearchTask researchTask)
    {
        return researchTaskMapper.selectTaskList(researchTask);
    }

    @Override
    public int insertTask(ResearchTask researchTask)
    {
        if (researchTask.getStatus() == null) {
            researchTask.setStatus("0");
        }
        researchTask.setCreateTime(DateUtils.getNowDate());
        return researchTaskMapper.insertTask(researchTask);
    }

    @Override
    public int updateTask(ResearchTask researchTask)
    {
        researchTask.setUpdateTime(DateUtils.getNowDate());
        return researchTaskMapper.updateTask(researchTask);
    }

    @Override
    public int deleteTaskByIds(String ids)
    {
        return researchTaskMapper.deleteTaskByIds(Convert.toStrArray(ids));
    }
}
