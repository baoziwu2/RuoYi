package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.RyResearchTask;
import com.ruoyi.system.service.IRyResearchTaskService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科研任务Controller
 * 
 * @author ruoyi
 * @date 2026-01-28
 */
@Controller
@RequestMapping("/system/task")
public class RyResearchTaskController extends BaseController
{
    private String prefix = "system/task";

    @Autowired
    private IRyResearchTaskService ryResearchTaskService;

    @RequiresPermissions("system:task:view")
    @GetMapping()
    public String task()
    {
        return prefix + "/task";
    }

    /**
     * 查询科研任务列表
     */
    @RequiresPermissions("system:task:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyResearchTask ryResearchTask)
    {
        startPage();
        List<RyResearchTask> list = ryResearchTaskService.selectRyResearchTaskList(ryResearchTask);
        return getDataTable(list);
    }

    /**
     * 导出科研任务列表
     */
    @RequiresPermissions("system:task:export")
    @Log(title = "科研任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyResearchTask ryResearchTask)
    {
        List<RyResearchTask> list = ryResearchTaskService.selectRyResearchTaskList(ryResearchTask);
        ExcelUtil<RyResearchTask> util = new ExcelUtil<RyResearchTask>(RyResearchTask.class);
        return util.exportExcel(list, "科研任务数据");
    }

    /**
     * 新增科研任务
     */
    @RequiresPermissions("system:task:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存科研任务
     */
    @RequiresPermissions("system:task:add")
    @Log(title = "科研任务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyResearchTask ryResearchTask)
    {
        return toAjax(ryResearchTaskService.insertRyResearchTask(ryResearchTask));
    }

    /**
     * 修改科研任务
     */
    @RequiresPermissions("system:task:edit")
    @GetMapping("/edit/{taskId}")
    public String edit(@PathVariable("taskId") Long taskId, ModelMap mmap)
    {
        RyResearchTask ryResearchTask = ryResearchTaskService.selectRyResearchTaskByTaskId(taskId);
        mmap.put("ryResearchTask", ryResearchTask);
        return prefix + "/edit";
    }

    /**
     * 修改保存科研任务
     */
    @RequiresPermissions("system:task:edit")
    @Log(title = "科研任务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyResearchTask ryResearchTask)
    {
        return toAjax(ryResearchTaskService.updateRyResearchTask(ryResearchTask));
    }

    /**
     * 删除科研任务
     */
    @RequiresPermissions("system:task:remove")
    @Log(title = "科研任务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryResearchTaskService.deleteRyResearchTaskByTaskIds(ids));
    }
}
