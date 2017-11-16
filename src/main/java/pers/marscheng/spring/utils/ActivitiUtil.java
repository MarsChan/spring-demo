package pers.marscheng.spring.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * activiti需要的工具类
 *
 * @author marscheng
 * @create 2017-11-01 下午4:33
 */
public class ActivitiUtil {

    public static ArrayList<String> list() {
        String basePath = ActivitiUtil.class.getResource("/").getPath();
        //basePath = basePath.substring(1, basePath.length());
        //System.out.println(basePath  + "workflow");
        //System.out.println((new File(basePath + "workflow")).list());
        String[] fileNames = (new File(basePath + File.separator + "workflow")).list();
        ArrayList<String> bpmnFileNames = new ArrayList<>();
        String bpmnPattern = ".*bpmn$";
        String zipPattern = ".*zip$";
        for (String fileName : fileNames){
            System.out.println(Pattern.matches(bpmnPattern,fileName));
            if(Pattern.matches(bpmnPattern,fileName)||Pattern.matches(zipPattern,fileName)){ //正则表达式,
                // 取可以部署的文件
                bpmnFileNames.add(fileName);
            }
        }
        return bpmnFileNames;
    }
}
