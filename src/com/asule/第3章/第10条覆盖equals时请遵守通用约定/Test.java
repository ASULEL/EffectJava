package com.asule.第3章.第10条覆盖equals时请遵守通用约定;

/**
 * @author ASuLe
 * @date 2023/1/4 17:07
 */
public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat().setAge(1).setName("tom").setColor("black");
        BlackCat cat2 = new BlackCat();
        cat2.setName("tom").setAge(1);
        //问题:违背了对称性
        //结果1:true 结果2:false
        //解决办法:
        // 1、在子类中去兼容父类
        // 2、子类调用父类的equals
        System.out.println(cat1.equals(cat2));
        System.out.println(cat2.equals(cat1));
    }
}
