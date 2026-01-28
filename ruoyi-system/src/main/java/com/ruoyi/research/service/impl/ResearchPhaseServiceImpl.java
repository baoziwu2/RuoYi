package com.ruoyi.research.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.research.mapper.ResearchPhaseMapper;
import com.ruoyi.research.domain.ResearchPhase;
import com.ruoyi.research.service.IResearchPhaseService;
import com.ruoyi.common.core.text.Convert;

/**
 * Research Phase Service Implementation
 */
@Service
public class ResearchPhaseServiceImpl implements IResearchPhaseService 
{
    @Autowired
    private ResearchPhaseMapper researchPhaseMapper;

    @Override
    public ResearchPhase selectPhaseById(Long phaseId)
    {
        return researchPhaseMapper.selectPhaseById(phaseId);
    }

    @Override
    public List<ResearchPhase> selectPhaseList(ResearchPhase researchPhase)
    {
        return researchPhaseMapper.selectPhaseList(researchPhase);
    }

    @Override
    public int insertPhase(ResearchPhase researchPhase)
    {
        researchPhase.setCreateTime(DateUtils.getNowDate());
        return researchPhaseMapper.insertPhase(researchPhase);
    }

    @Override
    public int updatePhase(ResearchPhase researchPhase)
    {
        researchPhase.setUpdateTime(DateUtils.getNowDate());
        return researchPhaseMapper.updatePhase(researchPhase);
    }

    @Override
    public int deletePhaseByIds(String ids)
    {
        return researchPhaseMapper.deletePhaseByIds(Convert.toStrArray(ids));
    }
}
