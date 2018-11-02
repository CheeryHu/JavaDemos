package com.cheeryhu.java.design.builder;

public class Client {

    public static void main(String[] args){
        MyStringBuilder sb = new MyStringBuilder();
        final int count = 26;
        for(int i = 0; i < count; i++){
            sb.append((char)('a' + i));
        }
        System.out.println(sb.toString());
    }
}
