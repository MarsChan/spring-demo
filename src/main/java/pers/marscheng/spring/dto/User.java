/**
 * @Description: TODO
 * @date: 2017年9月25日
 * @author: marscheng
 * @version: 1.0.0
 * @Copyright: 2017 marscheng
 */
package pers.marscheng.spring.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Description: 测试user实体
 * @author: marscheng
 * @date: 2017年9月25日 下午1:55:55
 *
 */
//@Entity //声明当前类为hibernate映射到数据库中的实体类
//@Table(name = "t_user")
public class User {
    @Id //申明此列为主键
    @GeneratedValue(strategy = GenerationType.AUTO)//根据不同数据库自动选择合适的id生成方案，这里使用mysql,为递增型
    private Integer id;
    private String name;
    private String passWord;
    private SysRoleEntity roleEntity;
    private Date birthDay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "id:"+id+"===name:"+name+"===password"+passWord;
    }

    public SysRoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(SysRoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
