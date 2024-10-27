package com.qbc.sys.sysuser.service;

import com.qbc.common.pojo.PageInfo;
import com.qbc.common.pojo.Result;
import com.qbc.common.service.CommonServiceImpl;
import com.qbc.sys.sysuser.pojo.SysUser;
import com.qbc.sys.sysuser.repository.SysUserRepository;
import com.qbc.sys.sysuser.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @ClassNme SysUserServiceImpl
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/27 9:52
 * @Version 1.0
 **/
@Service
@Transactional
public class SysUserServiceImpl extends CommonServiceImpl<SysUserVo, SysUser, String> implements SysUserService{

    @Autowired
    private EntityManager em;

    @Autowired
    private SysUserRepository sysUserRepository;



    @Override
    public Result<SysUserVo> findByLoginName(String username) {
        return null;
    }

    @Override
    public Result<SysUserVo> resetPassword(String userId) {
        return null;
    }

    @Override
    public Result<PageInfo<SysUserVo>> page(SysUserVo entityVo) {
        //这里可以直接调父类的page方法，当然也可以像下面这样自定义SQL
        //Result<PageInfo<SysUserVo>> result = super.page(entityVo);

        return null;
    }

    @Override
    public Result<SysUserVo> save(SysUserVo entityVo) {
        return null;
    }

    @Override
    public Result<String> delete(String id) {
        return null;
    }
}
