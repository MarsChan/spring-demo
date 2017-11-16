package pers.marscheng.spring.service;

import java.util.Set;

/**
 * 角色业务逻辑层接口
 *
 * @author marscheng
 * @create 2017-11-15 下午7:41
 */
public interface RoleService {
    Set<String> findRoles(Long... roleIds); //根据角色编号得到角色标识符列表
    Set<String> findPermissions(Long[] roleIds); //根据角色编号得到权限字符串列表
}
