package com.wt.myspringcloud.common.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {

    public static void main(String[] args) {
        try {
            // 创建一个ServerSocket监听8080端口
            ServerSocket serverSocket = new ServerSocket(8080);
            // 等待请求
            Socket socket = serverSocket.accept();
            // 接收到请求后使用socket进行通信,创建BufferedReader用于读取数据
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            System.out.println("received from client: " + line);
            // 创建PrintWriter用于发送数据
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("received data: " + line);
            pw.flush();
            // 关闭资源
            br.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}