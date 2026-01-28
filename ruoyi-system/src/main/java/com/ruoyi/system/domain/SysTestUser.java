package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测试用户对象 sys_test_user
 * 
 * @author ruoyi
 * @date 2026-01-27
 */
public class SysTestUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private String userCode;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 性别 */
    @Excel(name = "性别")
    private String userSex;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String userPhone;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String userEmail;

    /** 用户余额 */
    @Excel(name = "用户余额")
    private BigDecimal userBalance;

    /** 帐号状态 */
    @Excel(name = "帐号状态")
    private String status;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setUserCode(String userCode) 
    {
        this.userCode = userCode;
    }

    public String getUserCode() 
    {
        return userCode;
    }

    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }

    public void setUserSex(String userSex) 
    {
        this.userSex = userSex;
    }

    public String getUserSex() 
    {
        return userSex;
    }

    public void setUserPhone(String userPhone) 
    {
        this.userPhone = userPhone;
    }

    public String getUserPhone() 
    {
        return userPhone;
    }

    public void setUserEmail(String userEmail) 
    {
        this.userEmail = userEmail;
    }

    public String getUserEmail() 
    {
        return userEmail;
    }

    public void setUserBalance(BigDecimal userBalance) 
    {
        this.userBalance = userBalance;
    }

    public BigDecimal getUserBalance() 
    {
        return userBalance;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("userCode", getUserCode())
            .append("userName", getUserName())
            .append("userSex", getUserSex())
            .append("userPhone", getUserPhone())
            .append("userEmail", getUserEmail())
            .append("userBalance", getUserBalance())
            .append("status", getStatus())
            .toString();
    }
}
