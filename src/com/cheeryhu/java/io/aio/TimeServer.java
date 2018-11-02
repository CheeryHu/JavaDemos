package com.cheeryhu.java.io.aio;

import java.io.IOException;

/**
 * 异步非阻塞NIO
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if(null != args && args.length > 0){
            try{
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                //
            }
        }

        new Thread(new AsyncTimeServerHandler(port),"nio-AsyncTimeServerHandler-001").start();
    }
}
