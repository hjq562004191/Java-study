package cn.hjq.Maptest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 统计每个单词出现的次数
 * this is a cat and taha is a mice and where is the food?
 *
 * 存储到map中
 * key：String
 *value：自定义类型
 *
 * "分拣"思路
 * 1.为所有的key创建容器
 * 之后容器存放相应的valude
 * 2.第二次之后直接使用容器存放值
 */

public class test001 {
    public static void main(String[] args) {
        String str  = "this is a cat and taha is a mice and where is the food?";
        //分割字符串
        String[] strArray = str.split(" ");
        //存到map中
        Map<String,Letter> letters = new HashMap<>();
//        for (String temp:strArray) {//第一种
//            if (!letters.containsKey(temp)){
//                letters.put(temp,new Letter());
//            }
//            Letter col = letters.get(temp);
//            col.setCount(col.getCount()+1);
//        }
        for (String temp:strArray) {//第二种
            if (!letters.containsKey(temp)){
                Letter col = new Letter();
                col.setCount(1);
                letters.put(temp,col);
            }else {
                Letter col = letters.get(temp);
                col.setCount(col.getCount()+1);
            }

        }

        //输出map的值
        Set<String> keys= letters.keySet();
        for (String key:keys) {
            Letter col = letters.get(key);
            System.out.println("字母："+key+",次数"+col.getCount());
        }
    }
}
