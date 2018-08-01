package UDP;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/**
 * 客户端
 * 1.创建客户端 + 端口
 * 2.准备数据
 * 3.打包（发送的地点及端口）
 */
public class Myclient {
    public static void main(String[] args) throws IOException {
//        1.创建客户端 + 端口
        DatagramSocket socket = new DatagramSocket(6666);
//        2.准备数据

        byte[] data = convert(98.12);
//        3.打包（发送的地点及端口）
        DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("DESKTOP-KD73RPO",8888));
        //4.发送
        socket.send(packet);
        socket.close();
    }

    public static byte[] convert(double num) throws IOException {
        byte[] data = null;
        ByteArrayOutputStream os  =new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeDouble(num);
        dos.flush();

        //获取数据
        data = os.toByteArray();
        return data;
    }
}
