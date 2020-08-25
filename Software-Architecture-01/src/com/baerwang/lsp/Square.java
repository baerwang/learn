package com.baerwang.lsp;

/**
 * @author baerwang
 * @since 2020/8/25 22:02
 */
public class Square extends Rectangle {

    private long length;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    @Override
    public long getWidth() {
        return length;
    }

    @Override
    public long getHeight() {
        return length;
    }
}
