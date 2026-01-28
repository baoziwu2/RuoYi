package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysTestUser;
import com.ruoyi.system.service.ISysTestUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system/testUser")
public class SysTestUserController extends BaseController {
    private String prefix = "system/testUser";

    @Autowired
    private ISysTestUserService sysTestUserService;

    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user() {
        return prefix + "/user";
    }

    @RequiresPermissions("system:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysTestUser sysTestUser) {
        startPage();
        List<SysTestUser> list = sysTestUserService.selectSysTestUserList(sysTestUser);
        return getDataTable(list);
    }

    @RequiresPermissions("system:user:export")
    @Log(title = "测试用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysTestUser sysTestUser) {
        List<SysTestUser> list = sysTestUserService.selectSysTestUserList(sysTestUser);
        ExcelUtil<SysTestUser> util = new ExcelUtil<SysTestUser>(SysTestUser.class);
        return util.exportExcel(list, "测试用户数据");
    }

    @RequiresPermissions("system:user:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("system:user:add")
    @Log(title = "测试用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysTestUser sysTestUser) {
        return toAjax(sysTestUserService.insertSysTestUser(sysTestUser));
    }

    @RequiresPermissions("system:user:edit")
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap) {
        SysTestUser sysTestUser = sysTestUserService.selectSysTestUserByUserId(userId);
        mmap.put("sysTestUser", sysTestUser);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:user:edit")
    @Log(title = "测试用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysTestUser sysTestUser) {
        return toAjax(sysTestUserService.updateSysTestUser(sysTestUser));
    }

    @RequiresPermissions("system:user:remove")
    @Log(title = "测试用户", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysTestUserService.deleteSysTestUserByUserIds(ids));
    }
}
