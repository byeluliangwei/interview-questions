package cn.luliangwei.interview.questions.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * socket客户端
 */
public class SocketClient {

    public static String host = "localhost";
    public static int port = 9527;
    
    public static void main(String[] args) {
        System.out.println("客户端启动...");
        System.out.println("客户端收到 \'down\'的时候,客户端终止");
        while(true) {
            Socket socket = null;
            try {
                socket = new Socket(host, port);
                System.out.println("请输入向客户端发送的数据...");
                DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
                String send = new BufferedReader(new InputStreamReader(System.in)).readLine();
                dataOut.writeUTF(send);
                
                //读取服务端反馈回来的数据
                DataInputStream dataIn = new DataInputStream(socket.getInputStream());
                String ret = dataIn.readUTF();
                System.out.println("服务端反馈回来的数据是："+ret);
                if("down".equals(ret)) {
                    System.out.println("客户端收到：down 即将关闭");
                    Thread.sleep(1000);
                    break;
                }
                dataOut.close();
                dataIn.close();
            } catch (IOException |InterruptedException e) {
                System.out.println("客户端异常..."+e.getMessage());
            } finally {
                if(socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        System.out.println("客户端finally 异常..." + e.getMessage());
                    }
                }
            }
        }
    }
}
