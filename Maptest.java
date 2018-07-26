package cn.hjq.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map的基本用法
 */
public class Maptest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,"qqqw");
        map.put(2,new wife("热巴"));
        wife w = (wife) map.get(2);
//      wife w = (wife) new map.get(2);
        System.out.println(w.name);
    }
}

class wife{
    String name;

    public wife(String name) {
        this.name = name;
    }
}
