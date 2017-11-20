package pers.marscheng.spring.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 用户密码加密方法
 *
 * @author marscheng
 * @create 2017-11-16 下午2:07
 */
public class PasswordHelper {
    public enum AlgorithmName{
        MD5("md5");
        private String value;

        private AlgorithmName(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }
    private static RandomNumberGenerator randomNumberGenerator =
            new SecureRandomNumberGenerator();
    private static final int hashIterations = 2;

    public static void encryptPassword(String algorithmName, Object user, String password, String
            salt,String usercode) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        //首字母大写,用于构造set get函数
        password = password.substring(0, 1).toUpperCase() + password.substring(1);
        salt = salt.substring(0, 1).toUpperCase() + salt.substring(1);
        usercode = usercode.substring(0, 1).toUpperCase() + usercode.substring(1);

        Class<?> cls = user.getClass();

        //获取属性的set get方法
        Method getUsercode = cls.getMethod("get"+usercode);
        Method getPassword = cls.getMethod("get" + password);
        Method setPassword = cls.getMethod("set" + password, String.class);
        Method setSalt = cls.getMethod("set" + salt, String.class);
        Method getSalt = cls.getMethod("get"+salt);

        setSalt.invoke(user,randomNumberGenerator.nextBytes().toHex());

        String credentialsSalt = (String)getUsercode.invoke(user)+(String) getSalt.invoke(user);

        String newPassword = new SimpleHash(
                algorithmName,
                getPassword.invoke(user),
                ByteSource.Util.bytes(credentialsSalt),
                hashIterations
        ).toHex();

        setPassword.invoke(user,newPassword);
    }

    //public static void main(String[] args){
    //    SysUserEntity user = new SysUserEntity();
    //
    //    user.setUsercode("zhangsan");
    //    user.setUsername("张三");
    //    user.setPassword("123456");
    //    user.setLocked(false);
    //
    //    try {
    //        PasswordHelper.encryptPassword("md5",user,"password","salt","usercode");
    //
    //        System.out.println(user.getSalt());
    //        System.out.println(user.getPassword());
    //    } catch (NoSuchMethodException e) {
    //        e.printStackTrace();
    //    } catch (InvocationTargetException e) {
    //        e.printStackTrace();
    //    } catch (IllegalAccessException e) {
    //        e.printStackTrace();
    //    }
    //}
}
