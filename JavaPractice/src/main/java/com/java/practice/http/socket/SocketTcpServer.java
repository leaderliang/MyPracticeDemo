package com.java.practice.http.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO
 * <p>
 * Note: ServerSocket 可以对应多个 Socket,应对多个客户端进行连接
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/19 23:35
 */
public class SocketTcpServer {
    public static void main(String[] args) throws IOException {
        int port = 1207;
        // 1、监听端口 1207 端口，等待链接
        // 要求本机没有其他服务在监听该端口
        // 这个 ServerSocket 可以通过 accept() 返回多个 Socket(多个客户端链接服务器的并发)
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("当前服务端在 1207 端口，等待客户端链接中...");

        // 2、当没有客户端链接该端口时，程序会处于阻塞状态，等待链接
        // 如果有客户端链接，则会返回 socket 对象，程序继续向下执行
        Socket socket = serverSocket.accept();
        System.out.println("socket=" + socket.getClass());
        // 3、通过 socket.getInputStream() 读取客户端写入到数据通道的数据，然后展示

        InputStream inputStream = socket.getInputStream();
        // 4、IO 读取
        byte[] bufferBytes = new byte[1024];
        int readline = 0;
        while ((readline = inputStream.read(bufferBytes)) != -1){
            System.out.println("readLine=" + readline);
            System.out.println(new String(bufferBytes, 0, readline));
        }
        // 5、关闭流和 socket
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
