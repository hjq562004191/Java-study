package cn.test;

public class User {
    public static void main(String[] args) {
        Users[] arr = new Users[3];
        arr[0] = new Users(1001,"hh");
        arr[1] = new Users(1002,"jj");
        arr[2] = new Users(1003,"qq");
        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i].getName()+" "+arr[i].getId());
        }
    }
}

class Users{
    private int id;
    private String name;

    public  Users(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
