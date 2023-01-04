package com.asule.第3章.第10条覆盖equals时请遵守通用约定;

import java.util.Objects;

/**
 * @author ASuLe
 * @date 2023/1/4 17:11
 */
public class BlackCat extends Cat{

    public BlackCat() {
        super();
        super.setColor("black");
    }

    /**
     * 解决违背对称性的问题
     * 1、在子类中去兼容父类
     * 2、子类调用父类的equals
     * @param cat
     * @return
     */
//    @Override
//    public boolean equals(Object cat){
//        if (cat == this){
//            return true;
//        }
//        //问题 违背对称性
////        if (cat instanceof BlackCat){
////            BlackCat o = (BlackCat) cat;
////            return Objects.equals(getName(),o.getName()) &&
////                    Objects.equals(getAge(),o.getAge());
////        }
//
//        //解决1、在子类中去兼容父类
//        if (cat instanceof Cat){
//            Cat o = (Cat) cat;
//            return Objects.equals(getName(),o.getName()) &&
//                    Objects.equals(getAge(),o.getAge()) &&
//                    "black".equals(o.getColor());
//        }
//        return false;
//    }

    //解决2、子类调用父类的equals
    @Override
    public boolean equals(Object cat){
        return super.equals(cat);
    }
}
