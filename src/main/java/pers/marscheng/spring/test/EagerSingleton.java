package pers.marscheng.spring.test;

/**
 * 饿汉单例模式
 *
 * @author: marscheng
 * @date: 2017-12-01 下午4:36
 */
public class EagerSingleton {
    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return eagerSingleton;
    }

}
