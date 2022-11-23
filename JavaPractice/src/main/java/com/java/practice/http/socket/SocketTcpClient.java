package com.java.practice.http.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/20 00:01
 */
public class SocketTcpClient {
    public static void main(String[] args) throws IOException {
        // 1、链接服务器（ip、端口）
        Socket socket = new Socket(InetAddress.getLocalHost(), 1207);
        System.out.println("客户端 socket 返回=" + socket.getClass());

        // 2、连接上后，生成 socket，通过 socket.getOutputStream() 得到和 socket 对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        // 3、通过输出流，写入数据到 数据通道
        outputStream.write("hi, server, i'm client".getBytes(StandardCharsets.UTF_8));
//        outputStream.flush();
        outputStream.close();
        socket.close();

    }
}
