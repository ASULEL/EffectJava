package com.asule.第3章.第12条始终覆盖toString;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.默认toString() com.asule.第3章.第12条始终覆盖toString.Cat@1b6d3586
 * 2.重写toString() Cat{name='马楼', color='black', age=18}
 *
 * 很明显：默认的toString方法获得的信息基本没有什么价值，对于维护程序无法提供实质价值
 * toString的结果只适合打印输出，程序员阅读，而不能用户信息交互
 * @author ASuLe
 * @date 2023/1/5 14:22
 */
public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat().setName("马楼").setAge(18).setColor("black");
        //不要依赖toString的返回值去还原信息
        //也就是说这串信息是程序员去看的

        //Cat{name='马楼', color='black', age=18, no='null'}
        String catStr = cat.toString();
        System.out.println(catStr);

        //程序之间交互使用bean xml json
        Map<String,Object> catMap = new HashMap<>();
        catMap.put("name","tom");
        catMap.put("age",3);
        catMap.put("color","black");
        System.out.println(catMap);
        catMap.get("name");
    }
}
