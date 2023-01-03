package com.asule.三用私有构造器或者枚举类型强化Singleton属性;

import java.lang.reflect.Constructor;

/**
 * @author ASuLe
 * @date 2023/1/3 17:04
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //问题② 通过反射的方式还是能创建新的实例
        //getDeclaredConstructor();返回一个无参构造器
        Constructor<Singleton> con = Singleton.class.getDeclaredConstructor();
        con.setAccessible(true);
        Singleton singleton01 = con.newInstance();
        Singleton singleton02 = con.newInstance();
        System.out.println(singleton01 == singleton02);
    }
}
