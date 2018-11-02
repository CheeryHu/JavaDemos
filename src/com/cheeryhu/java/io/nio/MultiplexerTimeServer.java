package com.cheeryhu.java.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeServer implements Runnable{

    //
    private Selector selector;

    // 监听客户端的连接
    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;

    public MultiplexerTimeServer(int port){
        try{
            // 创建多路复用器
            selector = Selector.open();
            // 监听客户端的连接
            serverSocketChannel = ServerSocketChannel.open();
            // 非阻塞
            serverSocketChannel.configureBlocking(false);
            // 绑定监听端口
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            // 将serverSocketChannel注册到selector上监听accept事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port " + port);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void stop(){
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop){
            try{
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while(it.hasNext()){
                    key = it.next();
                    it.remove();
                    //
                    try{
                        handlerInput(key);
                    }catch (Exception e){
                        if(null != key){
                            key.cancel();
                            if(null != key.channel()){
                                key.channel().close();
                            }
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(null != selector){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handlerInput(SelectionKey key) throws IOException {
        if(key.isValid()){
            // 处理新接入的请求消息
            if(key.isAcceptable()){
                // 将新接入的客户端连接注册到selector上，监听read操作
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                // 相当于完成TCP的三次握手，TCP物理链路完成
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }

            if(key.isReadable()){
                // 异步读取客户端请求消息到缓冲区ByteBuffer
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if(readBytes > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server receive order:" + body);
                    String  currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)? new Date(System.currentTimeMillis()).toString() : "Bad order";
                    //异步写ByteBuffer到SocketChannel
                    doWrite(sc, currentTime);
                }else if(readBytes < 0){
                    key.cancel();
                    sc.close();
                }else {
                    ;
                }
            }
        }

    }

    private void doWrite(SocketChannel channel, String response) throws IOException {
        if(null != response && response.trim().length() > 0){
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }

}
