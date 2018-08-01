package Scoket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 客户端
 * 1.创建客户端  必须指定服务器 + 端口 此时就在连接 Socket(String host, int port)
 * 2.接收数据+发送数据
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1.创建客户端  必须指定服务器 + 端口 此时就在连接
        Socket client = new Socket("DESKTOP-KD73RPO",8888);
        //接受数据
//        BufferedReader br = new BufferedReader(
//                new InputStreamReader(
//                        client.getInputStream()
//                )
//        );
//        String msg = br.readLine();
//        System.out.println(msg);

        DataInputStream dis = new DataInputStream(client.getInputStream());
        String echo = dis.readUTF();
        System.out.println(echo);
    }
}
