package pers.marscheng.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.marscheng.spring.dao.SystemUserDao;
import pers.marscheng.spring.dto.SysUserEntity;
import pers.marscheng.spring.service.SystemUserService;
import pers.marscheng.spring.utils.PasswordHelper;

import java.util.Map;
import java.util.Set;

/**
 * 用户业务逻辑层
 *
 * @author marscheng
 * @create 2017-11-16 下午1:59
 */
@Service
public class SystemUserServiceImpl implements SystemUserService{

    @Autowired
    private SystemUserDao userDao;

    @Override
    public Boolean createUser(SysUserEntity user) {
        try {
            //对密码进行md5加盐加密
            PasswordHelper.encryptPassword(PasswordHelper.AlgorithmName.MD5.getValue(),user,
                    "password","salt","usercode");
            userDao.createUser(user);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public void changePassword(String userCode, String newPassword) {

    }

    @Override
    public SysUserEntity findByUsercode(String userCode) {
        return null;
    }

    @Override
    public Set<String> findRoles(String userCode) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String userCode) {
        return null;
    }

    @Override
    public Map<String, Object> login(String usercode, String password) {
        return null;
    }

    @Override
    public SysUserEntity addoRoles(String usercode, String roleids) {
        return null;
    }
}
