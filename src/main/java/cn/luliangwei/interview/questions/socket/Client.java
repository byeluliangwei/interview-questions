package cn.luliangwei.interview.questions.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

    public static int port = 1025;
    public static String host = "localhost";
    public static void main(String[] args) {
        try {
            System.out.println("启动客户端...");
            Socket socket = new Socket(host, port);
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("我是客户端发送的消息");
            
            writer.flush();
            writer.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("客户端异常..."+e.getMessage());
        }
        
    }
}
