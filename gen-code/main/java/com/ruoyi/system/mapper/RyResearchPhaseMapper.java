package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.RyResearchPhase;

/**
 * 科研阶段Mapper接口
 * 
 * @author ruoyi
 * @date 2026-01-28
 */
public interface RyResearchPhaseMapper 
{
    /**
     * 查询科研阶段
     * 
     * @param phaseId 科研阶段主键
     * @return 科研阶段
     */
    public RyResearchPhase selectRyResearchPhaseByPhaseId(Long phaseId);

    /**
     * 查询科研阶段列表
     * 
     * @param ryResearchPhase 科研阶段
     * @return 科研阶段集合
     */
    public List<RyResearchPhase> selectRyResearchPhaseList(RyResearchPhase ryResearchPhase);

    /**
     * 新增科研阶段
     * 
     * @param ryResearchPhase 科研阶段
     * @return 结果
     */
    public int insertRyResearchPhase(RyResearchPhase ryResearchPhase);

    /**
     * 修改科研阶段
     * 
     * @param ryResearchPhase 科研阶段
     * @return 结果
     */
    public int updateRyResearchPhase(RyResearchPhase ryResearchPhase);

    /**
     * 删除科研阶段
     * 
     * @param phaseId 科研阶段主键
     * @return 结果
     */
    public int deleteRyResearchPhaseByPhaseId(Long phaseId);

    /**
     * 批量删除科研阶段
     * 
     * @param phaseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRyResearchPhaseByPhaseIds(String[] phaseIds);
}
