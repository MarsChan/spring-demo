package pers.marscheng.spring.test;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import pers.marscheng.spring.dto.SysRoleEntity;
import pers.marscheng.spring.dto.User;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 工具类测试
 *
 * @author: marscheng
 * @date: 2017-12-01 下午4:38
 */
public class BeanUtilsTest {
    private static void testPopulate() throws InvocationTargetException, IllegalAccessException {
        User user = new User();

        Map<String,Object> map = new LinkedHashMap<>();

        map.put("id","123");
        map.put("name","张三");
        map.put("edit","1111");
        Map<String,Object> role = new LinkedHashMap<>();
        role.put("role","123");
        map.put("roleEntity",role);
        map.put("birthDay","1992-07-10");
        Map<String,Object> rolemap = (Map<String,Object>)map.get("roleEntity");
        map.remove("roleEntity");
        BeanUtils.copyProperties(user,map);
        SysRoleEntity roleEntity = new SysRoleEntity();



        BeanUtils.copyProperties(roleEntity,rolemap);
        user.setRoleEntity(roleEntity);

        System.out.println(user.toString());
        System.out.println(user.getRoleEntity().getRole());
        System.out.println(user.getBirthDay().toString());
        System.out.println(user.getBirthDay().getClass().getName());
    }

    public static void main(String[] args) {
        try {
            CustomerDateConverter customerDateConverter = new CustomerDateConverter();
            ConvertUtils.register(customerDateConverter, Date.class);
            testPopulate();
        } catch (InvocationTargetException e) {
            //e.printStackTrace();
        } catch (IllegalAccessException e) {
            //e.printStackTrace();
        }
    }
}
