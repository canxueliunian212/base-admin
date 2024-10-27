package com.qbc.sys.sysauthority.pojo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassNme SysAuthority
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/27 9:58
 * @Version 1.0
 **/
@Entity
@Table(name = "sys_authority")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SysAuthority implements Serializable {
    @Id
    private String authorityId;//权限id

    private String authorityName;//权限名称，ROLE_开头，全大写

    private String authorityContent;//权限内容，可访问的url，多个时用,隔开

    private String authorityRemark;//权限描述

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SysAuthority that = (SysAuthority) o;
        return authorityId != null && Objects.equals(authorityId, that.authorityId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
