package chatDemo02;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 发送数据线程
 *
 */
public class Send implements Runnable{
    private Scanner console;
    private DataOutputStream dos;
    private boolean isRunning = true;

    public Send(){
        console = new Scanner(System.in);
    }
    public Send(Socket client) throws IOException {
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            isRunning = false;
            dos.close();
            console.close();
            //e.printStackTrace();
        }
    }

    private String getMsgFromConsole(){
        return console.nextLine();
    }

    public void send() throws IOException {
        String msg = getMsgFromConsole();
        try {
             if (null != msg){
                dos.writeUTF(msg);
             }
            } catch (IOException e) {
               // e.printStackTrace();
            isRunning = false;
            dos.close();
            console.close();
            }

    }
    @Override
    public void run() {
    while (isRunning){
       try {
           send();
       } catch (IOException e) {
           e.printStackTrace();
       }
}
    }
}
