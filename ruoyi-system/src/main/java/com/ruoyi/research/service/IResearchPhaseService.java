package com.ruoyi.research.service;

import java.util.List;
import com.ruoyi.research.domain.ResearchPhase;

/**
 * Research Phase Service Interface
 */
public interface IResearchPhaseService 
{
    public ResearchPhase selectPhaseById(Long phaseId);
    public List<ResearchPhase> selectPhaseList(ResearchPhase researchPhase);
    public int insertPhase(ResearchPhase researchPhase);
    public int updatePhase(ResearchPhase researchPhase);
    public int deletePhaseByIds(String ids);
}
