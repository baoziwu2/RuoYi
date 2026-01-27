package com.ruoyi.web.controller.demo.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 演示新表格
 */
@Controller
@RequestMapping("/demo/testTable")
public class TestTableController extends BaseController {
    private final static Map<Integer, TestUserTableModel> users = new LinkedHashMap<Integer, TestUserTableModel>();

    private String prefix = "demo/table";

    @GetMapping()
    public String testTable() {
        return prefix + "/testTable";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestUserTableModel userModel) {
        TableDataInfo rspData = new TableDataInfo();
        List<TestUserTableModel> userList = new ArrayList<TestUserTableModel>(users.values());
        if (StringUtils.isNotEmpty(userModel.getUserName())) {
            userList.clear();
            for (Map.Entry<Integer, TestUserTableModel> entry : users.entrySet()) {
                if (entry.getValue().getUserName().equals(userModel.getUserName())) {
                    userList.add(entry.getValue());
                }
            }
        }
        rspData.setRows(userList);
        rspData.setTotal(userList.size());
        return rspData;
    }

    @GetMapping("/add")
    public String add() {
        return prefix + "/testTable_add";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TestUserTableModel user) {
        Integer userId = users.size() + 1;
        user.setUserId(userId);
        return AjaxResult.success(users.put(userId, user));
    }

    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Integer userId, ModelMap mmap) {
        mmap.put("user", users.get(userId));
        return prefix + "/testTable_edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestUserTableModel user) {
        return AjaxResult.success(users.put(user.getUserId(), user));
    }

    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        Integer[] userIds = Convert.toIntArray(ids);
        for (Integer userId : userIds) {
            users.remove(userId);
        }
        return AjaxResult.success();
    }

    public static class TestUserTableModel {
        private int userId;
        private String userCode;
        private String userName;
        private String userSex;
        private String userPhone;
        private String userEmail;
        private double userBalance;
        private String status;

        public TestUserTableModel() {

        }

        public TestUserTableModel(int userId, String userCode, String userName, String userSex, String userPhone, String userEmail, double userBalance, String status) {
            this.userId = userId;
            this.userCode = userCode;
            this.userName = userName;
            this.userSex = userSex;
            this.userPhone = userPhone;
            this.userEmail = userEmail;
            this.userBalance = userBalance;
            this.status = status;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserSex() {
            return userSex;
        }

        public void setUserSex(String userSex) {
            this.userSex = userSex;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public double getUserBalance() {
            return userBalance;
        }

        public void setUserBalance(double userBalance) {
            this.userBalance = userBalance;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
