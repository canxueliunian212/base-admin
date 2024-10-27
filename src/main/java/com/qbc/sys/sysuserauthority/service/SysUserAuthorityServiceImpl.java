package com.qbc.sys.sysuserauthority.service;

import com.qbc.common.pojo.Result;
import com.qbc.common.service.CommonServiceImpl;
import com.qbc.sys.sysuserauthority.pojo.SysUserAuthority;
import com.qbc.sys.sysuserauthority.vo.SysUserAuthorityVo;

import java.util.List;

/**
 * @ClassNme SysUserAuthorityServiceImpl
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/27 10:37
 * @Version 1.0
 **/
public class SysUserAuthorityServiceImpl extends CommonServiceImpl<SysUserAuthorityVo, SysUserAuthority, String> implements SysUserAuthorityService {
    @Override
    public Result<List<SysUserAuthorityVo>> findByUserId(String userId) {
        return null;
    }

    @Override
    public Result<Boolean> saveAllByUserId(String userId, String authorityIdList) {
        return null;
    }
}
