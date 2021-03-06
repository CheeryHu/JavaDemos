package com.cheeryhu.socket;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 天气客户端
 */
public class WeatherClient {

    public static void main(String[] args) throws IOException {
        //1.创建socket对象，和服务端建立连接
        Socket socket = new Socket("127.0.0.1", 12345);

        //2.发送城市名称
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("北京");
        System.out.println("请求查询天气: 北京");

        //3.接受返回结果使用输入流
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String result = dis.readUTF();
        System.out.println("北京的天气：" + result);

        //4.关闭流
        dis.close();
        dos.close();
    }
}
