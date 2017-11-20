package pers.marscheng.spring.service.impl;

import org.springframework.stereotype.Service;
import pers.marscheng.spring.service.RoleService;

import java.util.Set;

/**
 * 角色业务逻辑层
 *
 * @author marscheng
 * @create 2017-11-16 下午1:58
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public Set<String> findRoles(Long... roleIds) {
        return null;
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        return null;
    }
}
