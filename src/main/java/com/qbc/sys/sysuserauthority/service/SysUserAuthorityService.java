package com.qbc.sys.sysuserauthority.service;

import com.qbc.common.pojo.Result;
import com.qbc.common.service.CommonService;
import com.qbc.sys.sysuserauthority.pojo.SysUserAuthority;
import com.qbc.sys.sysuserauthority.vo.SysUserAuthorityVo;

import java.util.List;

public interface SysUserAuthorityService  extends CommonService<SysUserAuthorityVo, SysUserAuthority, String> {

    Result<List<SysUserAuthorityVo>> findByUserId(String userId);

    Result<Boolean> saveAllByUserId(String userId, String authorityIdList);
}
