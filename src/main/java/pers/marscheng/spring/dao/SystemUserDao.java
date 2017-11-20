package pers.marscheng.spring.dao;

import pers.marscheng.spring.dto.SysUserEntity;

import java.util.Set;

/**
 * 用户数据交互层
 *
 * @author marscheng
 * @create 2017-11-16 下午6:57
 */
public interface SystemUserDao {
    SysUserEntity createUser(SysUserEntity user); //创建账户

    void changePassword(String userCode, String newPassword); //修改密码

    SysUserEntity findByUsercode(String userCode); //根据用户名查找用户

    Set<String> findRoles(String userCode);// 根据用户名查找其角色

    Set<String> findPermissions(String userCode);// 根据用户名查找其权限
}
