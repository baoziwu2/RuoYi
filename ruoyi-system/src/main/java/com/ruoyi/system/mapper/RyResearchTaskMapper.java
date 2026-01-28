package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.RyResearchTask;

/**
 * 科研任务Mapper接口
 * 
 * @author ruoyi
 * @date 2026-01-28
 */
public interface RyResearchTaskMapper 
{
    /**
     * 查询科研任务
     * 
     * @param taskId 科研任务主键
     * @return 科研任务
     */
    public RyResearchTask selectRyResearchTaskByTaskId(Long taskId);

    /**
     * 查询科研任务列表
     * 
     * @param ryResearchTask 科研任务
     * @return 科研任务集合
     */
    public List<RyResearchTask> selectRyResearchTaskList(RyResearchTask ryResearchTask);

    /**
     * 新增科研任务
     * 
     * @param ryResearchTask 科研任务
     * @return 结果
     */
    public int insertRyResearchTask(RyResearchTask ryResearchTask);

    /**
     * 修改科研任务
     * 
     * @param ryResearchTask 科研任务
     * @return 结果
     */
    public int updateRyResearchTask(RyResearchTask ryResearchTask);

    /**
     * 删除科研任务
     * 
     * @param taskId 科研任务主键
     * @return 结果
     */
    public int deleteRyResearchTaskByTaskId(Long taskId);

    /**
     * 批量删除科研任务
     * 
     * @param taskIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRyResearchTaskByTaskIds(String[] taskIds);
}
