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
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * Research Project Controller
 */
@Controller
@RequestMapping("/research/project")
public class ResearchProjectController extends BaseController
{
    private String prefix = "research/project";

    @Autowired
    private IResearchProjectService researchProjectService;

    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("research:project:list")
    @GetMapping()
    public String project()
    {
        return prefix + "/project";
    }

    @RequiresPermissions("research:audit:apply")
    @GetMapping("/apply")
    public String apply()
    {
        return prefix + "/project";
    }

    /**
     * Query Project List
     */
    @RequiresPermissions("research:project:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ResearchProject researchProject)
    {
        startPage();
        List<ResearchProject> list = researchProjectService.selectProjectList(researchProject);
        return getDataTable(list);
    }

    /**
     * Get Project Tree
     */
    @RequiresPermissions("research:project:list")
    @GetMapping("/tree/{projectId}")
    @ResponseBody
    public AjaxResult tree(@PathVariable("projectId") Long projectId)
    {
        return AjaxResult.success(researchProjectService.selectProjectTreeById(projectId));
    }

    /**
     * Add Project - Entry
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("users", userService.selectUserList(new SysUser()));
        return prefix + "/add";
    }

    /**
     * Add Project - Save
     */
    @Log(title = "Research Project", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ResearchProject researchProject)
    {
        researchProject.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(researchProjectService.insertProject(researchProject));
    }

    /**
     * Edit Project - Entry
     */
    @RequiresPermissions("research:project:edit")
    @GetMapping("/edit/{projectId}")
    public String edit(@PathVariable("projectId") Long projectId, ModelMap mmap)
    {
        ResearchProject researchProject = researchProjectService.selectProjectById(projectId);
        mmap.put("project", researchProject);
        mmap.put("users", userService.selectUserList(new SysUser()));
        return prefix + "/edit";
    }

    /**
     * Edit Project - Save
     */
    @RequiresPermissions("research:project:edit")
    @Log(title = "Research Project", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ResearchProject researchProject)
    {
        researchProject.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(researchProjectService.updateProject(researchProject));
    }

    /**
     * Delete Project
     */
    @RequiresPermissions("research:project:remove")
    @Log(title = "Research Project", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(researchProjectService.deleteProjectByIds(ids));
    }
}
