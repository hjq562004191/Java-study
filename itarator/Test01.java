package cn.hjq.itarator;

import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Set set = new HashSet();
        set.add("qqqq");
        set.add("www");
        set.add("eee");
        System.out.println(set);
        Iterator iter = set.iterator();
        while ( iter.hasNext())
        {
            String str = (String)  iter.next();
            System.out.println(str);
        }
    }
}
