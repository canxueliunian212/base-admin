package com.qbc.sys.sysuser.service;

import com.qbc.common.pojo.Result;
import com.qbc.common.service.CommonService;
import com.qbc.sys.sysuser.pojo.SysUser;
import com.qbc.sys.sysuser.vo.SysUserVo;

public interface SysUserService extends CommonService<SysUserVo, SysUser, String> {

    Result<SysUserVo> findByLoginName(String username);

    Result<SysUserVo> resetPassword(String userId);
}
