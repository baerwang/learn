package com.baerwang.singleton;

import java.util.LinkedHashMap;

/**
 * 单例模式（Singleton Pattern）
 * <p>
 * 单例模式是指确保一个类在任何情况下都绝对只有一个实例，并提供一个全局访问点。
 * 单例模式是创建型模式。
 * </p>
 *
 * @author baerwang
 * @since 2020/8/28
 */
public class SpTest {

    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("111", "111");
        linkedHashMap.put("222", "222");
        linkedHashMap.put("333", "333");
        linkedHashMap.put("444", "444");
        loopLinkedHashMap(linkedHashMap);
        linkedHashMap.get("111");
        loopLinkedHashMap(linkedHashMap);
        linkedHashMap.get("333");
        loopLinkedHashMap(linkedHashMap);
    }

    public static void loopLinkedHashMap(LinkedHashMap<String, String> linkedHashMap) {
        linkedHashMap.entrySet().iterator().forEachRemaining(System.out::println);
        System.out.println();
    }

}
