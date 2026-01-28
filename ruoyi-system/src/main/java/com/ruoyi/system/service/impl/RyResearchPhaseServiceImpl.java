package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RyResearchPhaseMapper;
import com.ruoyi.system.domain.RyResearchPhase;
import com.ruoyi.system.service.IRyResearchPhaseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 科研阶段Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-28
 */
@Service
public class RyResearchPhaseServiceImpl implements IRyResearchPhaseService 
{
    @Autowired
    private RyResearchPhaseMapper ryResearchPhaseMapper;

    /**
     * 查询科研阶段
     * 
     * @param phaseId 科研阶段主键
     * @return 科研阶段
     */
    @Override
    public RyResearchPhase selectRyResearchPhaseByPhaseId(Long phaseId)
    {
        return ryResearchPhaseMapper.selectRyResearchPhaseByPhaseId(phaseId);
    }

    /**
     * 查询科研阶段列表
     * 
     * @param ryResearchPhase 科研阶段
     * @return 科研阶段
     */
    @Override
    public List<RyResearchPhase> selectRyResearchPhaseList(RyResearchPhase ryResearchPhase)
    {
        return ryResearchPhaseMapper.selectRyResearchPhaseList(ryResearchPhase);
    }

    /**
     * 新增科研阶段
     * 
     * @param ryResearchPhase 科研阶段
     * @return 结果
     */
    @Override
    public int insertRyResearchPhase(RyResearchPhase ryResearchPhase)
    {
        ryResearchPhase.setCreateTime(DateUtils.getNowDate());
        return ryResearchPhaseMapper.insertRyResearchPhase(ryResearchPhase);
    }

    /**
     * 修改科研阶段
     * 
     * @param ryResearchPhase 科研阶段
     * @return 结果
     */
    @Override
    public int updateRyResearchPhase(RyResearchPhase ryResearchPhase)
    {
        ryResearchPhase.setUpdateTime(DateUtils.getNowDate());
        return ryResearchPhaseMapper.updateRyResearchPhase(ryResearchPhase);
    }

    /**
     * 批量删除科研阶段
     * 
     * @param phaseIds 需要删除的科研阶段主键
     * @return 结果
     */
    @Override
    public int deleteRyResearchPhaseByPhaseIds(String phaseIds)
    {
        return ryResearchPhaseMapper.deleteRyResearchPhaseByPhaseIds(Convert.toStrArray(phaseIds));
    }

    /**
     * 删除科研阶段信息
     * 
     * @param phaseId 科研阶段主键
     * @return 结果
     */
    @Override
    public int deleteRyResearchPhaseByPhaseId(Long phaseId)
    {
        return ryResearchPhaseMapper.deleteRyResearchPhaseByPhaseId(phaseId);
    }
}
