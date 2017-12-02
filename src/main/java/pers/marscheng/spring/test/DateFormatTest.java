package pers.marscheng.spring.test;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 测试日期格式
 *
 * @author marscheng
 * @create 2017-10-30 上午11:26
 */
public class DateFormatTest {
    List<String> lists;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //Date result1 = string2Date("2016-12-15", "yyyy-MM-dd");
        //System.out.println(result1);
        //Date result2 = string2Date("2016-12-15", "YYYY-MM-DD");
        //System.out.println(result2);
        //
        //Date date1 = new Date();
        //System.out.println(date2String(date1, "yyyy-MM-dd"));
        //System.out.println(date2String(date1, "yyyy-MM-DD"));

        //User user = new User();
        //user.setName("张三");
        //user.setId(123);
        //System.out.println(user.toString());
        //user = new User();
        //user.setName("李四");
        //System.out.println(user.toString());

        HashMap<Integer,Object> map = new HashMap<>();
        map.put(null,"hello");
        map.put(null,"你好");
        System.out.println(map.get(null));

    }


    // string 转date
    public static Date string2Date(String dateStr,String pa) {
        DateFormat format = new SimpleDateFormat(pa);
        Date date = null;
        // String转Date
        try {
            date = format.parse(dateStr); // Thu Jan 18 00:00:00 CST 2007
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String date2String(Date date,String pa){
        DateFormat format = new SimpleDateFormat(pa);

        return format.format(date);
    }



}
