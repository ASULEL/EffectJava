package com.asule.三用私有构造器或者枚举类型强化Singleton属性;

/**
 * jdk1.5之后
 * 第二种:直接声明enum枚举类
 *      枚举类天然不能实例化
 *
 * 第三种
 * @Component(Scope="singleton")
 * Spring下默认就是单例，如果是其他模式会破坏单例这个原则
 * @author ASuLe
 * @date 2023/1/3 19:02
 */
public enum Singleton02 {

    INSTANCE;

    public void dosh(){

    }

    public void dosh2(){

    }
}
