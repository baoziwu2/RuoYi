package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.RyResearchPhase;

/**
 * 科研阶段Service接口
 * 
 * @author ruoyi
 * @date 2026-01-28
 */
public interface IRyResearchPhaseService 
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
     * 批量删除科研阶段
     * 
     * @param phaseIds 需要删除的科研阶段主键集合
     * @return 结果
     */
    public int deleteRyResearchPhaseByPhaseIds(String phaseIds);

    /**
     * 删除科研阶段信息
     * 
     * @param phaseId 科研阶段主键
     * @return 结果
     */
    public int deleteRyResearchPhaseByPhaseId(Long phaseId);
}
