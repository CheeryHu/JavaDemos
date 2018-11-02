package com.cheeryhu.java.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
        attachment.asynchronousServerSocketChannel.accept(attachment,this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer);
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }
}
