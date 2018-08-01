package chatDemo01;

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
        Scanner s = new Scanner(System.in);
        String d = s.nextLine();
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(d);
        dos.flush();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);
    }
}
