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
import com.ruoyi.system.domain.RyResearchPhase;
import com.ruoyi.system.service.IRyResearchPhaseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科研阶段Controller
 * 
 * @author ruoyi
 * @date 2026-01-28
 */
@Controller
@RequestMapping("/system/phase")
public class RyResearchPhaseController extends BaseController
{
    private String prefix = "system/phase";

    @Autowired
    private IRyResearchPhaseService ryResearchPhaseService;

    @RequiresPermissions("system:phase:view")
    @GetMapping()
    public String phase()
    {
        return prefix + "/phase";
    }

    /**
     * 查询科研阶段列表
     */
    @RequiresPermissions("system:phase:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyResearchPhase ryResearchPhase)
    {
        startPage();
        List<RyResearchPhase> list = ryResearchPhaseService.selectRyResearchPhaseList(ryResearchPhase);
        return getDataTable(list);
    }

    /**
     * 导出科研阶段列表
     */
    @RequiresPermissions("system:phase:export")
    @Log(title = "科研阶段", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyResearchPhase ryResearchPhase)
    {
        List<RyResearchPhase> list = ryResearchPhaseService.selectRyResearchPhaseList(ryResearchPhase);
        ExcelUtil<RyResearchPhase> util = new ExcelUtil<RyResearchPhase>(RyResearchPhase.class);
        return util.exportExcel(list, "科研阶段数据");
    }

    /**
     * 新增科研阶段
     */
    @RequiresPermissions("system:phase:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存科研阶段
     */
    @RequiresPermissions("system:phase:add")
    @Log(title = "科研阶段", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyResearchPhase ryResearchPhase)
    {
        return toAjax(ryResearchPhaseService.insertRyResearchPhase(ryResearchPhase));
    }

    /**
     * 修改科研阶段
     */
    @RequiresPermissions("system:phase:edit")
    @GetMapping("/edit/{phaseId}")
    public String edit(@PathVariable("phaseId") Long phaseId, ModelMap mmap)
    {
        RyResearchPhase ryResearchPhase = ryResearchPhaseService.selectRyResearchPhaseByPhaseId(phaseId);
        mmap.put("ryResearchPhase", ryResearchPhase);
        return prefix + "/edit";
    }

    /**
     * 修改保存科研阶段
     */
    @RequiresPermissions("system:phase:edit")
    @Log(title = "科研阶段", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyResearchPhase ryResearchPhase)
    {
        return toAjax(ryResearchPhaseService.updateRyResearchPhase(ryResearchPhase));
    }

    /**
     * 删除科研阶段
     */
    @RequiresPermissions("system:phase:remove")
    @Log(title = "科研阶段", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryResearchPhaseService.deleteRyResearchPhaseByPhaseIds(ids));
    }
}
