package cn.hjq.Maptest;

import java.util.*;

public class test002 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        exam(list);

        //统计
        Map<String,ClassRoom> rooms = new HashMap<>();
        count(rooms,list);
        printScore(rooms);
    }

    public static void count(Map<String,ClassRoom> rooms,List<Student> list)
    {
        for (Student stu:list){
            String no = stu.getNo();
            double score = stu.getScore();
            //根据班级编号 查看 Map是否存在该班机 分拣思路
            ClassRoom room = rooms.get(no);
            if (room == null){
                room  = new ClassRoom(no);
                rooms.put(no,room);
            }

            //存总分
            room.setTotal(room.getTotal()+score);
            //加学生
            room.getStus().add(stu);
        }
    }

    public static void printScore(Map<String,ClassRoom> rooms){
        Set<Map.Entry<String,ClassRoom>> entrySet = rooms.entrySet();
        Iterator<Map.Entry<String,ClassRoom>> it= entrySet.iterator();
        while (it.hasNext()){
            Map.Entry<String,ClassRoom> entry = it.next();
            ClassRoom room = entry.getValue();
            double avg = room.getTotal()/room.getStus().size();
            System.out.println("班级号为："+room.getNo()+"总分"+room.getTotal()+"平均分"+avg);
        }


    }

    public static void exam(List<Student> list) {
        list.add(new Student("a","001",60));
        list.add(new Student("b","002",82));
        list.add(new Student("c","001",54));
        list.add(new Student("d","003",81));
        list.add(new Student("e","002",73));
    }
}
