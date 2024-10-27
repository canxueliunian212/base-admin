package com.qbc.sys.sysuserauthority.pojo;

import com.qbc.sys.sysauthority.pojo.SysAuthority;
import com.qbc.sys.sysuser.pojo.SysUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassNme SysUserAuthority
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/27 10:25
 * @Version 1.0
 **/
@Entity
@Table(name = "sys_user_authority")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SysUserAuthority implements Serializable {

    @Id
    private String userAuthorityId;//用户权限表id

    private String userId;//用户id

    private String authorityId;//权限id

    private Date createTime;//创建时间

    private Date updateTime;//修改时间
    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private SysUser sysUser;

    @OneToOne
    @JoinColumn(name = "authorityId",referencedColumnName = "authorityId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private SysAuthority sysAuthority;//权限

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SysUserAuthority that = (SysUserAuthority) o;
        return userAuthorityId != null && Objects.equals(userAuthorityId, that.userAuthorityId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
