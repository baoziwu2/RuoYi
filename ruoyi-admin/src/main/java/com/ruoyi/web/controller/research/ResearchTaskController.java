package com.ruoyi.web.controller.research;

import java.util.List;
import java.util.Date;
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
import com.ruoyi.research.domain.ResearchTask;
import com.ruoyi.research.domain.ResearchPhase;
import com.ruoyi.research.service.IResearchTaskService;
import com.ruoyi.research.service.IResearchPhaseService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.ShiroUtils;

/**
 * Research Task Controller
 */
@Controller
@RequestMapping("/research/task")
public class ResearchTaskController extends BaseController
{
    private String prefix = "research/task";

    @Autowired
    private IResearchTaskService researchTaskService;
    
    @Autowired
    private IResearchPhaseService researchPhaseService;
    
    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("research:task:list")
    @GetMapping()
    public String task(Long phaseId, ModelMap mmap)
    {
        if (phaseId != null) {
            mmap.put("phaseId", phaseId);
            ResearchPhase phase = researchPhaseService.selectPhaseById(phaseId);
            mmap.put("phase", phase);
            mmap.put("isSetup", true);
        } else {
            mmap.put("isSetup", false);
        }
        mmap.put("userId", ShiroUtils.getUserId());
        mmap.put("isAdmin", ShiroUtils.getSysUser().isAdmin());
        return prefix + "/task";
    }

    @RequiresPermissions("research:task:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ResearchTask researchTask)
    {
        startPage();
        if (researchTask.getIsMyTask()) {
             researchTask.setAssignedUserId(ShiroUtils.getUserId());
        }
        List<ResearchTask> list = researchTaskService.selectTaskList(researchTask);
        return getDataTable(list);
    }
    
    /**
     * Complete Task
     */
    @Log(title = "Research Task", businessType = BusinessType.UPDATE)
    @PostMapping("/complete")
    @ResponseBody
    public AjaxResult complete(Long taskId)
    {
        ResearchTask task = researchTaskService.selectTaskById(taskId);
        if (task == null) {
            return error("Task not found");
        }
        if (!task.getAssignedUserId().equals(ShiroUtils.getUserId()) && !ShiroUtils.getSysUser().isAdmin()) {
             return error("You are not authorized to complete this task.");
        }
        
        task.setStatus("1"); // Completed
        task.setFinishTime(new Date());
        return toAjax(researchTaskService.updateTask(task));
    }
    
    /**
     * Add Task
     */
    @GetMapping("/add/{phaseId}")
    public String add(@PathVariable("phaseId") Long phaseId, ModelMap mmap)
    {
        mmap.put("phaseId", phaseId);
        mmap.put("users", userService.selectUserList(new SysUser()));
        return prefix + "/add";
    }

    @RequiresPermissions("research:audit:setup")
    @Log(title = "Research Task", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ResearchTask researchTask)
    {
        if (researchTask.getAssignedUserId() == null) {
            return error("Tasks must have assigned executor");
        }
        researchTask.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(researchTaskService.insertTask(researchTask));
    }

    /**
     * Edit Task
     */
    @RequiresPermissions("research:audit:setup")
    @GetMapping("/edit/{taskId}")
    public String edit(@PathVariable("taskId") Long taskId, ModelMap mmap)
    {
        ResearchTask researchTask = researchTaskService.selectTaskById(taskId);
        mmap.put("task", researchTask);
        mmap.put("users", userService.selectUserList(new SysUser()));
        return prefix + "/edit";
    }

    @RequiresPermissions("research:audit:setup")
    @Log(title = "Research Task", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ResearchTask researchTask)
    {
        if (researchTask.getAssignedUserId() == null) {
             return error("Tasks must have assigned executor");
        }
        researchTask.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(researchTaskService.updateTask(researchTask));
    }

    @RequiresPermissions("research:audit:setup")
    @Log(title = "Research Task", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(researchTaskService.deleteTaskByIds(ids));
    }
}
