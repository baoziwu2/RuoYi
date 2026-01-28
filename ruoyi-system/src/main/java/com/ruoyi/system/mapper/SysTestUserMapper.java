package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysTestUser;

/**
 * 测试用户Mapper接口
 * 
 * @author ruoyi
 * @date 2026-01-27
 */
public interface SysTestUserMapper 
{
    /**
     * 查询测试用户
     * 
     * @param userId 测试用户主键
     * @return 测试用户
     */
    public SysTestUser selectSysTestUserByUserId(Long userId);

    /**
     * 查询测试用户列表
     * 
     * @param sysTestUser 测试用户
     * @return 测试用户集合
     */
    public List<SysTestUser> selectSysTestUserList(SysTestUser sysTestUser);

    /**
     * 新增测试用户
     * 
     * @param sysTestUser 测试用户
     * @return 结果
     */
    public int insertSysTestUser(SysTestUser sysTestUser);

    /**
     * 修改测试用户
     * 
     * @param sysTestUser 测试用户
     * @return 结果
     */
    public int updateSysTestUser(SysTestUser sysTestUser);

    /**
     * 删除测试用户
     * 
     * @param userId 测试用户主键
     * @return 结果
     */
    public int deleteSysTestUserByUserId(Long userId);

    /**
     * 批量删除测试用户
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysTestUserByUserIds(String[] userIds);
}
