package pers.marscheng.spring.service;

import pers.marscheng.spring.dto.SysUserEntity;

import java.util.Map;
import java.util.Set;

/**
 * 用户业务逻辑层接口
 *
 * @author marscheng
 * @create 2017-11-16 下午1:52
 */
public interface SystemUserService {
    Boolean createUser(SysUserEntity user); //创建账户

    void changePassword(String userCode, String newPassword); //修改密码

    Map<String, Object> login(String usercode, String password);//通过用户名登录

    SysUserEntity findByUsercode(String userCode); //根据用户名查找用户

    Set<String> findRoles(String userCode);// 根据用户名查找其角色

    Set<String> findPermissions(String userCode);// 根据用户名查找其权限

    /**
     * 根据用户代码给用户赋权
     * @param usercode
     * @param roleids
     * @return
     */
    SysUserEntity addoRoles(String usercode,String roleids);





}
