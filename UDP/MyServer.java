package UDP;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 服务端
 * 1.创建服务端+端口
 * 2.准备接收容器
 * 3.封装成 包
 * 4.接收数据
 * 5.分析数据
 * 6.释放
 */
public class MyServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(8888);// * 1.创建服务端+端口

        byte[] con = new byte[1024];  //.准备接收容器
        //3.封装成 包
        DatagramPacket packet = new DatagramPacket(con,con.length);
        //4.接收数据
        server.receive(packet);
        //5.分析数据
        byte[] data =packet.getData();
        int len = packet.getLength();
        System.out.println(convert(data));
        //6.释放
        server.close();

    }

    public static double convert(byte[] data) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
        double num = dis.readDouble();
        dis.close();
        return num;
    }
}
