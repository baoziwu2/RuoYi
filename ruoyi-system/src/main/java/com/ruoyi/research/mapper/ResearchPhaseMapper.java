package com.ruoyi.research.mapper;

import java.util.List;
import com.ruoyi.research.domain.ResearchPhase;

/**
 * Research Phase Mapper Interface
 */
public interface ResearchPhaseMapper 
{
    public ResearchPhase selectPhaseById(Long phaseId);
    public List<ResearchPhase> selectPhaseList(ResearchPhase researchPhase);
    public int insertPhase(ResearchPhase researchPhase);
    public int updatePhase(ResearchPhase researchPhase);
    public int deletePhaseById(Long phaseId);
    public int deletePhaseByIds(String[] phaseIds);
}
