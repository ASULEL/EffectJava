package com.asule.第2章.第6条避免创建不必要的对象;

import java.util.Date;

/**
 * 1.重用单个对象，不要在每次需要的时候就创建一个相同功能的新对象
 * @author ASuLe
 * @date 2023/1/4 13:17
 */
public class Person {


    private Date birthday;
    private String name;

    private static final Date date00 = new Date(2000,0,0);
    private static final Date date10 = new Date(2010,0,0);

    private Person(Date birthday){
        if (birthday == null){
            throw new NullPointerException();
        }
        this.birthday = birthday;
    }

    /**
     * 是否是00后
     * @return
     */
    public boolean isAfter00(){
        //问题2
        //业务是可以实现，但是每次比较都要创建两个Date对象会消耗资源，不太友好
        //如何优化？
        //重复使用的相同变量用静态变量去使用
//        Date date = new Date(2000,0,0);
//        Date date2 = new Date(2010,0,0);
        return birthday.after(date00) && birthday.before(date10);
    }
}
