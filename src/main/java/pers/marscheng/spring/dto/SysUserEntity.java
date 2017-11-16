package pers.marscheng.spring.dto;

import javax.persistence.*;

/**
 * @author marscheng
 * @create 2017-11-15 下午5:16
 */
@Entity
@Table(name = "sys_user", schema = "hibernateDB", catalog = "")
public class SysUserEntity {
    private String usercode;
    private String username;
    private String password;
    private String salt;
    private String roleIds;
    private Byte locked;
    private Integer pram1;
    private Integer pram2;
    private Integer pram3;
    private Integer pram4;

    @Id
    @Column(name = "usercode")
    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "role_ids")
    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    @Basic
    @Column(name = "locked")
    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    @Basic
    @Column(name = "pram1")
    public Integer getPram1() {
        return pram1;
    }

    public void setPram1(Integer pram1) {
        this.pram1 = pram1;
    }

    @Basic
    @Column(name = "pram2")
    public Integer getPram2() {
        return pram2;
    }

    public void setPram2(Integer pram2) {
        this.pram2 = pram2;
    }

    @Basic
    @Column(name = "pram3")
    public Integer getPram3() {
        return pram3;
    }

    public void setPram3(Integer pram3) {
        this.pram3 = pram3;
    }

    @Basic
    @Column(name = "pram4")
    public Integer getPram4() {
        return pram4;
    }

    public void setPram4(Integer pram4) {
        this.pram4 = pram4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserEntity that = (SysUserEntity) o;

        if (usercode != null ? !usercode.equals(that.usercode) : that.usercode != null)
            return false;
        if (username != null ? !username.equals(that.username) : that.username != null)
            return false;
        if (password != null ? !password.equals(that.password) : that.password != null)
            return false;
        if (salt != null ? !salt.equals(that.salt) : that.salt != null) return false;
        if (roleIds != null ? !roleIds.equals(that.roleIds) : that.roleIds != null) return false;
        if (locked != null ? !locked.equals(that.locked) : that.locked != null) return false;
        if (pram1 != null ? !pram1.equals(that.pram1) : that.pram1 != null) return false;
        if (pram2 != null ? !pram2.equals(that.pram2) : that.pram2 != null) return false;
        if (pram3 != null ? !pram3.equals(that.pram3) : that.pram3 != null) return false;
        if (pram4 != null ? !pram4.equals(that.pram4) : that.pram4 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usercode != null ? usercode.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (roleIds != null ? roleIds.hashCode() : 0);
        result = 31 * result + (locked != null ? locked.hashCode() : 0);
        result = 31 * result + (pram1 != null ? pram1.hashCode() : 0);
        result = 31 * result + (pram2 != null ? pram2.hashCode() : 0);
        result = 31 * result + (pram3 != null ? pram3.hashCode() : 0);
        result = 31 * result + (pram4 != null ? pram4.hashCode() : 0);
        return result;
    }
}
