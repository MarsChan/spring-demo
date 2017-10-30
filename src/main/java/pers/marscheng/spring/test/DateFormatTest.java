package pers.marscheng.spring.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试日期格式
 *
 * @author marscheng
 * @create 2017-10-30 上午11:26
 */
public class DateFormatTest {

    public static void main(String[] args) {
        Date result1 = string2Date("2016-12-15", "yyyy-MM-dd");
        System.out.println(result1);
        Date result2 = string2Date("2016-12-15", "YYYY-MM-DD");
        System.out.println(result2);

        Date date1 = new Date();
        System.out.println(date2String(date1, "yyyy-MM-dd"));
        System.out.println(date2String(date1, "yyyy-MM-DD"));
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
