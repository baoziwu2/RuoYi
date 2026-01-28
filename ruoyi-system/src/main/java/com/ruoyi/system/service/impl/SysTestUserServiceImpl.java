package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTestUserMapper;
import com.ruoyi.system.domain.SysTestUser;
import com.ruoyi.system.service.ISysTestUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 测试用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-27
 */
@Service
public class SysTestUserServiceImpl implements ISysTestUserService 
{
    @Autowired
    private SysTestUserMapper sysTestUserMapper;

    /**
     * 查询测试用户
     * 
     * @param userId 测试用户主键
     * @return 测试用户
     */
    @Override
    public SysTestUser selectSysTestUserByUserId(Long userId)
    {
        return sysTestUserMapper.selectSysTestUserByUserId(userId);
    }

    /**
     * 查询测试用户列表
     * 
     * @param sysTestUser 测试用户
     * @return 测试用户
     */
    @Override
    public List<SysTestUser> selectSysTestUserList(SysTestUser sysTestUser)
    {
        return sysTestUserMapper.selectSysTestUserList(sysTestUser);
    }

    /**
     * 新增测试用户
     * 
     * @param sysTestUser 测试用户
     * @return 结果
     */
    @Override
    public int insertSysTestUser(SysTestUser sysTestUser)
    {
        return sysTestUserMapper.insertSysTestUser(sysTestUser);
    }

    /**
     * 修改测试用户
     * 
     * @param sysTestUser 测试用户
     * @return 结果
     */
    @Override
    public int updateSysTestUser(SysTestUser sysTestUser)
    {
        return sysTestUserMapper.updateSysTestUser(sysTestUser);
    }

    /**
     * 批量删除测试用户
     * 
     * @param userIds 需要删除的测试用户主键
     * @return 结果
     */
    @Override
    public int deleteSysTestUserByUserIds(String userIds)
    {
        return sysTestUserMapper.deleteSysTestUserByUserIds(Convert.toStrArray(userIds));
    }

    /**
     * 删除测试用户信息
     * 
     * @param userId 测试用户主键
     * @return 结果
     */
    @Override
    public int deleteSysTestUserByUserId(Long userId)
    {
        return sysTestUserMapper.deleteSysTestUserByUserId(userId);
    }
}
