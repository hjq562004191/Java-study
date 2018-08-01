package chatDemo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务端：发送数据+接收数据
 */

public class Server {
    private List<Mychannel> all = new ArrayList<>();

    public static void main(String[] args) throws IOException {
       new Server().start();



//        Socket client = server.accept();
//        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//        DataInputStream dis = new DataInputStream(client.getInputStream());
//
//        while (true) {
//            String msg = dis.readUTF();
//            System.out.println(msg);
//            dos.writeUTF(msg);
//            dos.flush();
//        }
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true){
            Socket client = server.accept();
            Mychannel channel = new Mychannel(client);
            all.add(channel);
            new Thread(channel).start();
        }

    }
    /**
     * 一个客户端一条道路
     *
     */
    private  class Mychannel implements Runnable{
        private DataOutputStream dos ;
        private DataInputStream dis ;
        private boolean isRunning = true;

        public Mychannel(Socket client) throws IOException {
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                //e.printStackTrace();
                dis.close();
                dos.close();
                isRunning = false;
                all.remove(this);
            }
        }

        private void sendOthers() throws IOException {
            String msg = this.receive();
            for (Mychannel other:all
                 ) {
                if (other == this){
                    continue;
                }
                other.send(msg);
            }
        }
        private String receive() throws IOException {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                dis.close();
                dos.close();
                all.remove(this);
            }
            return msg;
        }

        private void send(String msg) {
            if (null == msg || msg.equals("")){
                return;
            }
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                try {
                    dos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        @Override
        public void run() {
            while (isRunning){
                try {
                    sendOthers();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


