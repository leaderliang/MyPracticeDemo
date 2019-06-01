package com.java.practice.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/30 18:03
 */
public class JavaIoTest {

     public static void main(String[] str){
        runIo();
     }

    private static void runIo() {
        try {
            ServerSocket serverSocket = new ServerSocket(1207);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String data;
            while ((data =  bufferedReader.readLine()) != null){
                bufferedWriter.write("data " + data);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}