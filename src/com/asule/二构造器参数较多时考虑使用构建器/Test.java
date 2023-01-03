package com.asule.二构造器参数较多时考虑使用构建器;

import java.time.LocalDateTime;

/**
 * @author ASuLe
 * @date 2023/1/3 14:33
 */
public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog(1,null,"blue", LocalDateTime.now(),1);
        //这种方式可以一个一个的传参
        //如果用setter方式来设置，id、birthday、color就不能有final关键字，那也就无法保证他们的唯一性，你只能通过if (id!=null) throw 抛出异常来校验
        Dog dog1 = new Dog.DogBuilder().id(1).name("朵朵").color("while").birthday(LocalDateTime.now()).build();
        System.out.println(dog1);
    }
}
