package com.asule.第2章.第3条用私有构造器或者枚举类型强化Singleton属性;

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
        //setAccessible();值为 true 则指示反射的对象在使用时应该取消Java语言访问检查。值为false则指示反射的对象应该实施Java语言访问检查;
        //由于JDK的安全检查耗时较多.所以通过setAccessible(true)的方式关闭安全检查就可以达到提升反射速度的目的
        con.setAccessible(true);
        //将无参构造修改之后，此时使用反射也只能生成一个实例
        Singleton singleton01 = con.newInstance();
        Singleton singleton02 = con.newInstance();
        System.out.println(singleton01 == singleton02);
    }
}
