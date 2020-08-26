package com.example.test.websocket.one;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketServer {
    public static String HOST = "127.0.0.1";
    public static int PORT = 8806;

    public static void startUp() throws Exception {
        // 监听端口的线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 处理每一条连接的数据读写的线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        // 启动的引导类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception{
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("logger", new LoggingHandler(LogLevel.INFO));
                            // 将请求和返回消息编码或解码成http
                            pipeline.addLast("http-codec", new HttpServerCodec());
                            // 使http的多个部分组合成一条完整的http
                            pipeline.addLast("aggregator", new HttpObjectAggregator(65536));
                            // 向客户端发送h5文件，主要是来支持websocket通信
                            pipeline.addLast("http-chunked", new ChunkedWriteHandler());
                            // 服务端自定义处理器
                            pipeline.addLast("handler", new WebSocketServerHandler());
                        }
                    })
                    // 开启心跳机制
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<NioServerSocketChannel>() {
                        protected void initChannel(NioServerSocketChannel ch) {
                            System.out.println("WebSocket服务端启动中...");
                        }
                    });

            Channel ch = serverBootstrap.bind(HOST, PORT).sync().channel();
            System.out.println("WebSocket host: "+ch.localAddress().toString().replace("/",""));
            ch.closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {
        startUp();
    }
}
