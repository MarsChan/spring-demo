package pers.marscheng.spring.service.impl;

import org.springframework.stereotype.Service;
import pers.marscheng.spring.dto.SysResourceEntity;
import pers.marscheng.spring.service.ResourceService;

import java.util.List;
import java.util.Set;

/**
 * 资源业务逻辑层
 *
 * @author marscheng
 * @create 2017-11-16 下午1:57
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Override
    public Set<String> findPermissions(Set<Long> resourceIds) {
        return null;
    }

    @Override
    public List<SysResourceEntity> findMenus(Set<String> permissions) {
        return null;
    }
}
