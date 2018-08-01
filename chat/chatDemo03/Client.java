package chatDemo03;

import chatDemo02.Receive;
import chatDemo02.Send;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * 创建客户端：发送数据+接收数据
 */
public class Client {
    public static void main(String[] args) throws IOException {

        System.out.println("请输入昵称");
        Scanner br = new Scanner(System.in);
        String name = br.nextLine();
        if (name.equals("")){
            return;
        }
        Socket client = new Socket("localhost",9999);
        new Thread(new chatDemo03.Send(client,name)).start();//一条路径
        new Thread(new chatDemo03.Receive(client)).start();//一条路径
    }

}
