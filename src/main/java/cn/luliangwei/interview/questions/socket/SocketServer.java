package cn.luliangwei.interview.questions.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * socket通信服务端
 */
public class SocketServer {

    public static int port = 9527;
    
    public static void main(String[] args) {
        System.out.println("服务端启动...");
        
        SocketServer server = new SocketServer();
        server.inti();
    }
    
    @SuppressWarnings("resource")
    public void inti() {
        try {
            ServerSocket server = new ServerSocket(port);
            while(true) {
                Socket socket = server.accept();
                
                //单开一个线程处理服务端接收到的消息
                new HandlerThread(socket);
            }
        } catch (IOException e) {
            System.out.println("Socket服务端异常..."+e.getMessage());
        }
    }
    
    //就是一个线程
    private static class HandlerThread implements Runnable{
        private Socket socket;
        
        public HandlerThread(Socket client) {
            socket = client;
            new Thread(this).start();
        }
        @Override
        public void run() {
            try {
                //读取客户端信息
                DataInputStream dataIn = new DataInputStream(socket.getInputStream());
                String unicodeData = dataIn.readUTF();
                System.out.println("服务端收到数据："+unicodeData);
                
                //给客户端反馈
                System.out.println("输入服务端向客户端反馈的数据：");
                String ret = new BufferedReader(new InputStreamReader(System.in)).readLine();
                DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
                dataOut.writeUTF(ret);
                dataIn.close();
                dataOut.close();
            }catch (IOException e) {
                System.out.println("Socket服务端异常..."+e.getMessage());
            }finally {
                if(socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                    System.out.println("服务端 finally异常..." + e.getMessage() );
                    }
                }
            }
        }
        
    }
}
