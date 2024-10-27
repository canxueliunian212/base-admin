package com.qbc.sys.sysauthority.vo;

import com.qbc.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassNme SysAuthorityVo
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/27 9:59
 * @Version 1.0
 **/
@Data
public class SysAuthorityVo extends PageCondition implements Serializable {

    private String authorityId;//权限id

    private String authorityName;//权限名称，ROLE_开头，全大写

    private String authorityContent;//权限内容，可访问的url，多个时用,隔开

    private String authorityRemark;//权限描述

    private Date createTime;//创建时间

    private Date updateTime;//修改时间
}
