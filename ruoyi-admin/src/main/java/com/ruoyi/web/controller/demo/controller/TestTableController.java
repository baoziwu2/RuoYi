package com.ruoyi.web.controller.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;

// 1. 引入 System 模块下的 Domain 和 Service
import com.ruoyi.system.domain.SysTestUser;
import com.ruoyi.system.service.ISysTestUserService;

@Controller
@RequestMapping("/demo/testTable")
public class TestTableController extends BaseController {

    // 2. 注入新的 Service
    @Autowired
    private ISysTestUserService sysTestUserService;

    private String prefix = "demo/table";

    @GetMapping()
    public String testTable() {
        return prefix + "/testTable";
    }

    /**
     * 查询列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysTestUser sysTestUser) {
        startPage();
        // 3. 调用 Service 查询，注意方法名要与你生成的 Service 接口一致
        List<SysTestUser> list = sysTestUserService.selectSysTestUserList(sysTestUser);
        return getDataTable(list);
    }

    /**
     * 新增页面
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/testTable_add";
    }

    /**
     * 新增保存
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysTestUser sysTestUser) {
        // 4. 调用 Service 插入
        return toAjax(sysTestUserService.insertSysTestUser(sysTestUser));
    }

    /**
     * 修改页面
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap) {
        // 5. 根据 ID 查询详情
        mmap.put("user", sysTestUserService.selectSysTestUserByUserId(userId));
        return prefix + "/testTable_edit";
    }

    /**
     * 修改保存
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysTestUser sysTestUser) {
        // 6. 调用 Service 更新
        return toAjax(sysTestUserService.updateSysTestUser(sysTestUser));
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        // 7. 调用 Service 删除
        return toAjax(sysTestUserService.deleteSysTestUserByUserIds(ids));
    }
}
