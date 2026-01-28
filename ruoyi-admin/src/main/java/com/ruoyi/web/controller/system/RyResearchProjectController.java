package com.ruoyi.web.controller.system;

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
import com.ruoyi.system.domain.RyResearchProject;
import com.ruoyi.system.service.IRyResearchProjectService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科研课题Controller
 * 
 * @author ruoyi
 * @date 2026-01-28
 */
@Controller
@RequestMapping("/system/project")
public class RyResearchProjectController extends BaseController {
    private String prefix = "system/project";

    @Autowired
    private IRyResearchProjectService ryResearchProjectService;

    @RequiresPermissions("system:project:view")
    @GetMapping()
    public String project() {
        return prefix + "/project";
    }

    /**
     * 查询科研课题列表
     */
    @RequiresPermissions("system:project:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyResearchProject ryResearchProject) {
        startPage();
        List<RyResearchProject> list = ryResearchProjectService.selectRyResearchProjectList(ryResearchProject);
        return getDataTable(list);
    }

    /**
     * 导出科研课题列表
     */
    @RequiresPermissions("system:project:export")
    @Log(title = "科研课题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyResearchProject ryResearchProject) {
        List<RyResearchProject> list = ryResearchProjectService.selectRyResearchProjectList(ryResearchProject);
        ExcelUtil<RyResearchProject> util = new ExcelUtil<RyResearchProject>(RyResearchProject.class);
        return util.exportExcel(list, "科研课题数据");
    }

    /**
     * 新增科研课题
     */
    @RequiresPermissions("system:project:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存科研课题
     */
    @RequiresPermissions("system:project:add")
    @Log(title = "科研课题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyResearchProject ryResearchProject) {
        // 自动绑定当前登录用户为申请人
        ryResearchProject.setApplicantId(getUserId());
        return toAjax(ryResearchProjectService.insertRyResearchProject(ryResearchProject));
    }

    /**
     * 审批页面 (我的审批)
     */
    @RequiresPermissions("system:project:audit")
    @GetMapping("/audit")
    public String audit() {
        return prefix + "/audit";
    }

    /**
     * 查询待审批列表
     */
    @RequiresPermissions("system:project:audit")
    @PostMapping("/listAudit")
    @ResponseBody
    public TableDataInfo listAudit(RyResearchProject ryResearchProject) {
        ryResearchProject.setStatus("0"); // 强制只查待审批
        startPage();
        List<RyResearchProject> list = ryResearchProjectService.selectRyResearchProjectList(ryResearchProject);
        return getDataTable(list);
    }

    /**
     * 课题立项页面
     */
    @RequiresPermissions("system:project:setup")
    @GetMapping("/setup")
    public String setup() {
        return prefix + "/setup";
    }

    /**
     * 查询已立项列表
     */
    @RequiresPermissions("system:project:setup")
    @PostMapping("/listSetup")
    @ResponseBody
    public TableDataInfo listSetup(RyResearchProject ryResearchProject) {
        ryResearchProject.setStatus("1"); // 强制只查已立项
        startPage();
        List<RyResearchProject> list = ryResearchProjectService.selectRyResearchProjectList(ryResearchProject);
        return getDataTable(list);
    }

    /**
     * 审核状态修改 (同意/拒绝)
     */
    @RequiresPermissions("system:project:audit")
    @Log(title = "科研课题审核", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(RyResearchProject project) {
        return toAjax(ryResearchProjectService.updateRyResearchProject(project));
    }

    /**
     * 修改科研课题
     */
    @RequiresPermissions("system:project:edit")
    @GetMapping("/edit/{projectId}")
    public String edit(@PathVariable("projectId") Long projectId, ModelMap mmap) {
        RyResearchProject ryResearchProject = ryResearchProjectService.selectRyResearchProjectByProjectId(projectId);
        mmap.put("ryResearchProject", ryResearchProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存科研课题
     */
    @RequiresPermissions("system:project:edit")
    @Log(title = "科研课题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyResearchProject ryResearchProject) {
        return toAjax(ryResearchProjectService.updateRyResearchProject(ryResearchProject));
    }

    /**
     * 删除科研课题
     */
    @RequiresPermissions("system:project:remove")
    @Log(title = "科研课题", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(ryResearchProjectService.deleteRyResearchProjectByProjectIds(ids));
    }
}
