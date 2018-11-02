package com.cheeryhu.nativeTest;

public class HelloNative {
    static{
        System.loadLibrary("HelloNative");
    }

    public static native void sayHello();

    public static void main(String[] args){
        new HelloNative().sayHello();
    }
}
