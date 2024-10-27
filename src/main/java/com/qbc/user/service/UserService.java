package com.qbc.user.service;

import com.qbc.common.pojo.Result;
import com.qbc.sys.sysuser.vo.SysUserVo;

public interface UserService {

    Result<SysUserVo> updatePassword(String oldPassword, String newPassword);

    Result<SysUserVo> updateUser(SysUserVo sysUserVo);
}
