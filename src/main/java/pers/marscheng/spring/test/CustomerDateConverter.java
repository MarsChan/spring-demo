package pers.marscheng.spring.test;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 支持beanutils转换时间
 *
 * @author: marscheng
 * @date: 2017-12-01 下午9:31
 */
public class CustomerDateConverter implements Converter {
    private final static SimpleDateFormat DATE_FORMATE_SHOW = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Object convert(Class type, Object value) {
        if (type.equals(java.util.Date.class) ) {
            try {
                return DATE_FORMATE_SHOW.parse(value.toString());
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}
