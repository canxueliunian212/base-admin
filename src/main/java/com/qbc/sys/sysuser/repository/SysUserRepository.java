package com.qbc.sys.sysuser.repository;

import com.qbc.common.repository.CommonRepository;
import com.qbc.sys.sysuser.pojo.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends CommonRepository<SysUser, String> {
    SysUser findByLoginName(String username);
}
