package StudentServer.server;

import StudentServer.denglu.studentdenglu;
import StudentServer.denglu.teacherdenglu;
import StudentServer.denglu.zhuceteacher;
import StudentServer.menu.Teachermenu;
import StudentServer.menu.Stumenu;

import java.util.Scanner;

@SuppressWarnings("all")
public class mainserver {

    public static void main(String[] args) throws Exception {
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\t\t\t\t----------------1.教师登陆----------------");
            System.out.println("\t\t\t\t----------------2.教师注册----------------");
            System.out.println("\t\t\t\t----------------3.学生登陆----------------");
            System.out.println("\t\t\t\t----------------0.退出    ----------------");
            System.out.print("\t\t\t\t\t\t请输入你要进行的操作:");
            choice = scanner.nextInt();
            if (choice == 0) break;
            switch (choice) {
                case 1:
                    dengluteacher();
                    break;
                case 2:
                    new zhuceteacher().zhuce();
                    break;
                case 3:
                    denglustudent();
                    break;
            }
        }


    }
    public static void dengluteacher() throws InterruptedException {
        int t = new teacherdenglu().denglu();
        if (t != 0) {
            Teachermenu teachermenu = new Teachermenu(t);
            teachermenu.menu();
        }
    }

    public static void denglustudent() throws Exception {
        int t = new studentdenglu().denglu();
        if (t != 0) {
            Stumenu stumenu = new Stumenu(t);
            stumenu.menu();
        }
    }
}