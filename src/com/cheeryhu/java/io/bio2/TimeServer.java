package com.cheeryhu.java.io.bio2;

import com.cheeryhu.java.io.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  伪NIO
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

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port:" + port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);
            while(true){
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        }catch (Exception e){
            if(server != null){
                System.out.println("The time server is closed!");
                server.close();
                server = null;
            }
        }

    }
}
