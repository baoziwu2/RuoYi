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
 * Research Setup Controller (Status = 1)
 */
@Controller
@RequestMapping("/research/project/setup")
public class ResearchSetupController extends BaseController
{
    private String prefix = "research/setup";

    @Autowired
    private IResearchProjectService researchProjectService;

    @RequiresPermissions("research:audit:setup")
    @GetMapping()
    public String setup()
    {
        return prefix + "/project";
    }

    /**
     * List Approved Projects (Status=1)
     */
    @RequiresPermissions("research:audit:setup")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ResearchProject researchProject)
    {
        startPage();
        researchProject.setStatus("1"); // Approved
        List<ResearchProject> list = researchProjectService.selectProjectList(researchProject);
        return getDataTable(list);
    }
}
