package com.ruoyi.web.controller.research;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.research.domain.ResearchPhase;
import com.ruoyi.research.domain.ResearchProject; // Added for project context
import com.ruoyi.research.service.IResearchPhaseService;
import com.ruoyi.research.service.IResearchProjectService; // Added for project context
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.ShiroUtils;

/**
 * Research Phase Controller
 */
@Controller
@RequestMapping("/research/phase")
public class ResearchPhaseController extends BaseController
{
    private String prefix = "research/phase";

    @Autowired
    private IResearchPhaseService researchPhaseService;
    
    @Autowired
    private IResearchProjectService researchProjectService;

    @RequiresPermissions("research:audit:setup")
    @GetMapping()
    public String phase(Long projectId, ModelMap mmap)
    {
        mmap.put("projectId", projectId);
        // Put project info
        ResearchProject project = researchProjectService.selectProjectById(projectId);
        mmap.put("project", project);
        return prefix + "/phase";
    }

    @RequiresPermissions("research:audit:setup")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ResearchPhase researchPhase)
    {
        startPage();
        List<ResearchPhase> list = researchPhaseService.selectPhaseList(researchPhase);
        return getDataTable(list);
    }
    
    /**
     * Add Phase
     */
    @GetMapping("/add/{projectId}")
    public String add(@PathVariable("projectId") Long projectId, ModelMap mmap)
    {
        mmap.put("projectId", projectId);
        return prefix + "/add";
    }

    @RequiresPermissions("research:audit:setup")
    @Log(title = "Research Phase", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ResearchPhase researchPhase)
    {
        researchPhase.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(researchPhaseService.insertPhase(researchPhase));
    }

    /**
     * Edit Phase
     */
    @RequiresPermissions("research:audit:setup")
    @GetMapping("/edit/{phaseId}")
    public String edit(@PathVariable("phaseId") Long phaseId, ModelMap mmap)
    {
        ResearchPhase researchPhase = researchPhaseService.selectPhaseById(phaseId);
        mmap.put("phase", researchPhase);
        return prefix + "/edit";
    }

    @RequiresPermissions("research:audit:setup")
    @Log(title = "Research Phase", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ResearchPhase researchPhase)
    {
        researchPhase.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(researchPhaseService.updatePhase(researchPhase));
    }

    @RequiresPermissions("research:audit:setup")
    @Log(title = "Research Phase", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(researchPhaseService.deletePhaseByIds(ids));
    }
}
