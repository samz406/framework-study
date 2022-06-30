package org.samz.mybatisdemo.config;

/**
 * @author: lilin
 * @Date: 2022/6/2 17:38
 * @Description:
 */
public class DataSourceHolder {


    private static final ThreadLocal<String> LOOKUP_KEY_HOLDER = new ThreadLocal();


    public static String get() {

        return LOOKUP_KEY_HOLDER.get();
    }

    public static void set(String key) {

        LOOKUP_KEY_HOLDER.set(key);
    }


    public static void remove() {

        LOOKUP_KEY_HOLDER.remove();
    }

}
