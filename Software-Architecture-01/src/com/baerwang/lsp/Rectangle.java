package com.baerwang.lsp;

/**
 * @author baerwang
 * @since 2020/8/25 22:01
 */
public class Rectangle implements Quadrangle {

    private long height;

    private long width;

    @Override
    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    @Override
    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }
}
