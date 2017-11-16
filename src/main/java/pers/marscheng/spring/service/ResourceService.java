package pers.marscheng.spring.service;

import pers.marscheng.spring.dto.SysResourceEntity;

import java.util.List;
import java.util.Set;

/**
 * 资源权限业务逻辑层
 *
 * @author marscheng
 * @create 2017-11-15 下午7:36
 */
public interface ResourceService {
    Set<String> findPermissions(Set<Long> resourceIds); //得到资源对应的权限字符串
    List<SysResourceEntity> findMenus(Set<String> permissions); //根据用户权限得到菜单
}
