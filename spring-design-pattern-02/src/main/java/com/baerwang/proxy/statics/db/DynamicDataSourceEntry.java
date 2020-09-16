package com.baerwang.proxy.statics.db;

/**
 * 动态切换数据源
 *
 * @author baerwang
 * @since 2020/8/30 6:28
 */
public class DynamicDataSourceEntry {

    private final static String DEFAULT_SOURCE = null;

    private final static ThreadLocal<String> LOCAL = new ThreadLocal<String>();

    private DynamicDataSourceEntry() {
    }

    /**
     * 清空数据源
     */
    public static void clear() {
        LOCAL.remove();
    }

    /**
     * 获取当前正在使用的数据源名字
     *
     * @return
     */
    public String get() {
        return LOCAL.get();
    }

    /**
     * 还原当前切换的数据源
     */
    public static void restore() {
        LOCAL.set(DEFAULT_SOURCE);
    }

    /**
     * 设置已知名字的数据源
     *
     * @param source
     */
    public static void set(String source) {
        LOCAL.set(source);
    }

    /**
     * 根据年份动态设置数据库
     *
     * @param year
     */
    public static void set(int year) {
        LOCAL.set("db_" + year);
    }
}
