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
import com.ruoyi.research.domain.ResearchProject;
import com.ruoyi.research.service.IResearchProjectService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.ShiroUtils;

/**
 * Research Audit Controller
 */
@Controller
@RequestMapping("/research/audit")
public class ResearchAuditController extends BaseController
{
    private String prefix = "research/audit";

    @Autowired
    private IResearchProjectService researchProjectService;

    @RequiresPermissions("research:audit:list")
    @GetMapping()
    public String audit()
    {
        return prefix + "/audit";
    }

    /**
     * Query Project List (Only Status=0)
     */
    @RequiresPermissions("research:audit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ResearchProject researchProject)
    {
        startPage();
        // Force status to "0" (Reviewing)
        researchProject.setStatus("0");
        List<ResearchProject> list = researchProjectService.selectProjectList(researchProject);
        return getDataTable(list);
    }

    /**
     * Agree (Status -> 1)
     */
    @RequiresPermissions("research:audit:audit")
    @Log(title = "Research Audit", businessType = BusinessType.UPDATE)
    @PostMapping("/agree")
    @ResponseBody
    public AjaxResult agree(Long projectId)
    {
        ResearchProject project = new ResearchProject();
        project.setProjectId(projectId);
        project.setStatus("1"); // Approved
        project.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(researchProjectService.updateProject(project));
    }

    /**
     * Reject - Entry (Modal for Remark)
     */
    @RequiresPermissions("research:audit:audit")
    @GetMapping("/reject/{projectId}")
    public String reject(@PathVariable("projectId") Long projectId, ModelMap mmap)
    {
        mmap.put("projectId", projectId);
        return prefix + "/reject";
    }

    /**
     * Reject - Save (Status -> 2)
     */
    @RequiresPermissions("research:audit:audit")
    @Log(title = "Research Audit", businessType = BusinessType.UPDATE)
    @PostMapping("/reject")
    @ResponseBody
    public AjaxResult rejectSave(ResearchProject researchProject)
    {
        researchProject.setStatus("2"); // Rejected
        researchProject.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(researchProjectService.updateProject(researchProject));
    }
}
