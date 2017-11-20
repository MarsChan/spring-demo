package pers.marscheng.spring.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import pers.marscheng.spring.dto.SysUserEntity;
import pers.marscheng.spring.service.SystemUserService;

/**
 * Realm继承类,记录用户信息的具体校验
 *
 * @author marscheng
 * @create 2017-11-15 下午6:40
 */
public class SystemAuthorizingRealm extends AuthorizingRealm{
    @Autowired
    private SystemUserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String usercode = (String)authenticationToken.getPrincipal();
        SysUserEntity userEntity = userService.findByUsercode(usercode);
        if(userEntity == null){ //账户不存在
            throw new UnknownAccountException();
        }

        if(Boolean.TRUE.equals(userEntity.getLocked())){ //账户已经被锁定
            throw new LockedAccountException();
        }

        return new SimpleAuthenticationInfo(userEntity.getUsercode(),userEntity.getPassword(),
                ByteSource.Util.bytes(userEntity.getUsercode()+userEntity.getSalt()),getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
