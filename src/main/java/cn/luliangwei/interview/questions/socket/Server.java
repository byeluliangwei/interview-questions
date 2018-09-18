package cn.luliangwei.interview.questions.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简单的socket server
 */
public class Server {

    public static int port = 1025;
    public static void main(String[] args) {
         try {
             System.out.println("启动服务端...");
            @SuppressWarnings("resource")
            ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            int len = 0;
            char[] buff = new char[1024];
            StringBuilder sb = new StringBuilder();
            while((len = reader.read(buff))!=-1) {
                sb.append(new String(buff,0,len));
            }
            System.out.println("服务端收到的消息为："+sb.toString());
            reader.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("服务端异常..."+e.getMessage());
        }
    }
}
