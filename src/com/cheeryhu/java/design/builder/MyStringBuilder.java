package com.cheeryhu.java.design.builder;

public class MyStringBuilder extends AbstractStringBuilder{
    public MyStringBuilder() {
        // 初始大小是16
        super(16);
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }
}
