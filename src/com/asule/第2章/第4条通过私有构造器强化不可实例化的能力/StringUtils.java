package com.asule.第2章.第4条通过私有构造器强化不可实例化的能力;

/**
 * 工具类不可实例化
 * 问题:仅仅声明为抽象类来强制该类不可以被实例化是不行的
 * @author ASuLe
 * @date 2023/1/4 12:40
 */
public abstract class StringUtils {

    /**
     * 为了避免工具类创建实例，可以将工具类私有化
     * 问题：但是通过反射的方式依然可以获取到实例
     * 回答:私有构造器中抛出异常
     */
//    private StringUtils(){
//        throw new RuntimeException("静态工具类不需要实例化");
//    }

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
