package pers.marscheng.spring.test;

/**
 * 懒汉单例模式
 *
 * @author: marscheng
 * @date: 2017-12-01 下午5:02
 */
public class LazySingleton {
    private static LazySingleton lazySingleton;

    private LazySingleton() {
    }

    synchronized public static LazySingleton GetInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}
