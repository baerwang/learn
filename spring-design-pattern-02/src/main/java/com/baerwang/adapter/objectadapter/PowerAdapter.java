package com.baerwang.adapter.objectadapter;

/**
 * @author baerwang
 * @since 2020/9/21 16:52
 */
public class PowerAdapter implements DC5 {

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5V() {
        int adapterInput = ac220.outputAC220V();
        // 变压器
        int adapterOutPut = adapterInput / 44;
        System.out.println("使用PowerAdapter输入AC：" + adapterInput + "v，输出DC：" + adapterOutPut + "V");
        return adapterOutPut;
    }
}
