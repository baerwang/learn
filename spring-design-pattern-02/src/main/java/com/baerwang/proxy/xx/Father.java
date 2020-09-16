package com.baerwang.proxy.xx;

/**
 * @author baerwang
 * @since 2020/8/30 6:17
 */
public class Father {

    private Son son;

    /**
     * 没有办法扩展
     *
     * @param son
     */
    public Father(Son son) {
        this.son = son;
    }

    public void findLove() {
        System.out.println("查看对象");
        son.findLove();
    }

}
