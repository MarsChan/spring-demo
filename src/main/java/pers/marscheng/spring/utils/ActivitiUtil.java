package pers.marscheng.spring.utils;

import java.io.File;

/**
 * activiti需要的工具类
 *
 * @author marscheng
 * @create 2017-11-01 下午4:33
 */
public class ActivitiUtil {

    public static String[] list() {
        String basePath = ActivitiUtil.class.getResource("/").getPath();
        //basePath = basePath.substring(1, basePath.length());
        System.out.println(basePath  + "workflow");
        System.out.println((new File(basePath + "workflow")).list());
        return (new File(basePath + File.separator + "workflow")).list();
    }
}
