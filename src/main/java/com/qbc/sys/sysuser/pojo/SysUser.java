package com.qbc.sys.sysuser.pojo;

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
 * @ClassNme SysUser
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/27 9:39
 * @Version 1.0
 **/
@Entity
@Table(name = "sys_user")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SysUser implements Serializable {

    @Id
    private String userId;//用户id

    private String loginName;//登录名

    private String userName;//用户名称

    private String password;//登录密码

    private String valid;//软删除标识，Y/N

    private String limitedIp;//限制允许登录的IP集合

    private Date expiredTime;//账号失效时间，超过时间将不能登录系统

    private Date lastChangePwdTime;//最近修改密码时间，超出时间间隔，提示用户修改密码

    private Date lastLoginTime;//最近登录时间，最后活跃时间

    private String limitMultiLogin;//是否允许账号同一个时刻多人在线，Y/N

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SysUser sysUser = (SysUser) o;
        return userId != null && Objects.equals(userId, sysUser.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
