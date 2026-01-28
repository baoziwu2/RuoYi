package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RyResearchTaskMapper;
import com.ruoyi.system.domain.RyResearchTask;
import com.ruoyi.system.service.IRyResearchTaskService;
import com.ruoyi.common.core.text.Convert;

/**
 * 科研任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-28
 */
@Service
public class RyResearchTaskServiceImpl implements IRyResearchTaskService 
{
    @Autowired
    private RyResearchTaskMapper ryResearchTaskMapper;

    /**
     * 查询科研任务
     * 
     * @param taskId 科研任务主键
     * @return 科研任务
     */
    @Override
    public RyResearchTask selectRyResearchTaskByTaskId(Long taskId)
    {
        return ryResearchTaskMapper.selectRyResearchTaskByTaskId(taskId);
    }

    /**
     * 查询科研任务列表
     * 
     * @param ryResearchTask 科研任务
     * @return 科研任务
     */
    @Override
    public List<RyResearchTask> selectRyResearchTaskList(RyResearchTask ryResearchTask)
    {
        return ryResearchTaskMapper.selectRyResearchTaskList(ryResearchTask);
    }

    /**
     * 新增科研任务
     * 
     * @param ryResearchTask 科研任务
     * @return 结果
     */
    @Override
    public int insertRyResearchTask(RyResearchTask ryResearchTask)
    {
        ryResearchTask.setCreateTime(DateUtils.getNowDate());
        return ryResearchTaskMapper.insertRyResearchTask(ryResearchTask);
    }

    /**
     * 修改科研任务
     * 
     * @param ryResearchTask 科研任务
     * @return 结果
     */
    @Override
    public int updateRyResearchTask(RyResearchTask ryResearchTask)
    {
        ryResearchTask.setUpdateTime(DateUtils.getNowDate());
        return ryResearchTaskMapper.updateRyResearchTask(ryResearchTask);
    }

    /**
     * 批量删除科研任务
     * 
     * @param taskIds 需要删除的科研任务主键
     * @return 结果
     */
    @Override
    public int deleteRyResearchTaskByTaskIds(String taskIds)
    {
        return ryResearchTaskMapper.deleteRyResearchTaskByTaskIds(Convert.toStrArray(taskIds));
    }

    /**
     * 删除科研任务信息
     * 
     * @param taskId 科研任务主键
     * @return 结果
     */
    @Override
    public int deleteRyResearchTaskByTaskId(Long taskId)
    {
        return ryResearchTaskMapper.deleteRyResearchTaskByTaskId(taskId);
    }
}
