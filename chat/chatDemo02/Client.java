package chatDemo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 创建客户端：发送数据+接收数据
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9999);
        new Thread(new Send(client)).start();//一条路径
        new Thread(new Receive(client)).start();//一条路径
    }

}
