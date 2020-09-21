package com.baerwang.adapter;

import com.baerwang.adapter.objectadapter.AC220;
import com.baerwang.adapter.objectadapter.DC5;
import com.baerwang.adapter.objectadapter.PowerAdapter;

/**
 * 适配器模式（Adapter Pattern）
 * <p>
 * 适配器模式是指将一个类的接口转换成用户期望的另一个接口，使原本接口不兼容的类可以一起工作，属于结构型设计模式。
 * 适用以下几种业务场景：
 * （1）已经存在的类的方法和需求不匹配（方法结果相同或相似）的情况。
 * （2）适配器模式不是软件初始阶段考虑的设计模式，是随着软件的发展，由于不同产品，不同厂家造成功能类似而接口不通的问题的解决方案，有亡羊补牢的感觉。
 * </p>
 *
 * @author baerwang
 * @since 2020/9/21 16:43
 */
public class AdapterTest {

    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.outputDC5V();
    }
}
