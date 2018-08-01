package Scoket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.创建服务器 指定端口  ServerSocket(int port)
 * 2.接收客户端连接 阻塞式
 * 3.发送数据+接收数据
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建服务器 指定端口  ServerSocket(int port)
        ServerSocket server = new ServerSocket(8888);
        //2.接收客户端连接 阻塞式
        Socket socket = server.accept();
        System.out.println("一个客户端建立连接");
        //发送数据
        String msg = "欢迎使用\n";
        //输出流
//        BufferedWriter bw = new BufferedWriter(
//                new OutputStreamWriter(
//                        socket.getOutputStream()
//                )
//        );
//        bw.write(msg);
//        bw.flush();
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();


    }
}
