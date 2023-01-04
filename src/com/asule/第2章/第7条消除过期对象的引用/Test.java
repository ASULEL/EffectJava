package com.asule.第2章.第7条消除过期对象的引用;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ASuLe
 * @date 2023/1/4 15:33
 */
public class Test {

    static Map<Integer, Object> map = new HashMap<>();
    static Student[] students = new Student[13];

    /**
     * 随着程序的执行，map中key为1和key为2的键值对已经不需要了
     * 但是对于jvm而言，会发现Test类有个map并含有key为1和2的键值对，但
     * 这两个键值对以后会不会用到程序是不知道的，只有编程的人知道，也就是
     * 说key为1和2的键值对无法被回收，即3和Student对象无法被回收
     * <p>
     * 但对于方法内的变量其生命周期属于方法栈，会随着方法栈的结束这个方法
     * 也会得到回收
     *
     * @param args
     */
    public static void main(String[] args) {
        map.put(1, 3);
        map.put(2, new Student());

        map.remove(2);


        for (int i = 0; i < 13; i++) {
            students[i] = new Student();
        }
        //假设student[12]以后不用了，但是程序是不知道的，如果不用students[12] = null;
        //那么student[12]会一直指向之前创建的Student对象
        //List也是如此，例如有0，1，2，3，4个List元素
        //当2被删除之后，会变成0，1，3，4，之前存放4的位置在List的remove源码中会指向null 即elementData[--size] = null;
        //如果不指向null，之前指向4的List的内存空间会永远指向其之前创建的对象，永远无法释放
        //一直到下次扩展到5个元素以上或者说等到系统停止，也有可能引来oom
        students[12] = null;

        FileInputStream fio = null;
        try {
            fio = new FileInputStream(new File(""));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           if (fio != null){
               try {
                   fio.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }

        //try-with-resource但是要实现AutoCloseable接口

        //FileInputStream是InputStream的子类
        //InputStream是Closeable的实现类
        //Closeable是AutoCloseable的子类
        //即FileInputStream是孙 InputStream是父 Closeable是爷 AutoCloseable是曾祖
        try(FileInputStream fio1 = new FileInputStream(new File(""))){

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
