package com.baerwang.lod;

/**
 * 迪米特原则（Law of Demeter，LoD）
 * <p>
 * 迪米特原则是指一个对象应该对其他对象保持最少的了解，又叫最少知道原则（Least Knowledge Principle，LKP），
 * 尽量降低类与类之间的耦合度。迪米特原则主要强调：只和朋友交流，不和陌生人说话。出现在成员变量、方法的输入、输出参数中的类都可以
 * 称为成员朋友类，而出现在方法体内部的类不属于朋友类。
 * </p>
 *
 * @author baerwang
 * @since 2020/8/25 6:38
 */
public class LodTest {

    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckNumber(teamLeader);
    }
}
