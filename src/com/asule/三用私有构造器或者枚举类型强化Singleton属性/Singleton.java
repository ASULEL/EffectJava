package com.asule.三用私有构造器或者枚举类型强化Singleton属性;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * jdk1.5之前
 * 第一种：整个系统的系统级别的信息只会是单例模式
 * @author ASuLe
 * @date 2023/1/3 16:42
 */
public class Singleton implements Serializable {
    //饿汉式
//    private static final Singleton SINGLETON = new Singleton();
    //懒汉式
    private static Singleton SINGLETON;

    private Singleton(){
        //关于问题②的解决办法
        if (SINGLETON != null){
            throw new RuntimeException("singleton exception");
        }else {
            SINGLETON = this;
        }
    }

    public static Singleton getInstance(){
        //懒汉式
        //问题：
        //①、如果外部有多个线程同时到了if (SINGLETON == null){，会同时new Singleton(); 然后 return SINGLETON;
        //例如有三个线程调用了这个方法，那前两个都会被第三个覆盖掉，系统中是第三个线程，即同时有多个线程new Singleton();的时候只会保留最后一个
        //
        //是否能忍受这种情况
        //否，解决办法：
        // 一、static 后面加 synchronized ,把整个方法加锁，每一次获取实例的时候都要加锁，性能比较差
        // 二、如下，第一个线程已经实例化了，第二个线程在synchronized同步锁中发现if语句不符合

        //②、通过反射的方式还是能够创造新的实例
        //解决办法：
        //修改构造器 （注意：看无参构造，让它在创造第二个实例的时候抛出异常）

        if (SINGLETON == null){
            synchronized (Singleton.class){
                if (SINGLETON == null){
                    SINGLETON = new Singleton();
                }
            }
        }
        return SINGLETON;
    }

    public void doSh(){
        System.out.println("do something");
    }


    public void doSh2() throws Exception {
        System.out.println("do something");
    }

    /**
     * 一个单例对象创建好后，有时候需要将对象序列化然后写入磁盘，下次使用时再从磁盘中读取对象并进行反序列化，将其转化为内存对象。
     * 反序列化后的对象会重新分配内存，即重新创建，如果序列化的对象目标为单例对象，就违背了单例模式的初衷，相当于破坏了单例。
     *
     * 序列化:序列化就是把内存中的状态通过转换成字节码的形式。从而转换成一个I/O流，写入其他地方(可以是磁盘，网络I/O)
     * 内存中的状态会永久保存下来
     *
     * 反序列化:就是将已经持久化的字节码对象转换成I/O流，通过I/O流的读取，进而将读取的内容转换成Java对象，在转换过程
     * 中会重新创建对象
     * @return
     */
    private Object readResolve(){
        return SINGLETON;
    }
}
