package com.asule.第3章.第10条覆盖equals时请遵守通用约定;

import java.util.Objects;

/**
 * @author ASuLe
 * @date 2023/1/4 16:58
 */
public class Cat {
    private String name;
    private String color;
    private Integer age;

    //2.1 自反性: 非null的对象 使用x.equals(x)应该是true
    //2.2 对称性: x.equals(y)和有y.equals(x)必须结果一样 //注意父子继承的设计
    //2.3 传递性: x.equals(y)为true,且y.equals(z)为true时,要求x.equals(z)也必须时true //具有equals判断的不同类中，
    //使用了不同信息来计算，比如x和y比较使用了属性a和b,y和z比较使用属性b和c,x和z比较使用属性a和c
    //2.4 一致性: 如果x和y的信息没有变化，那么多次调用x.equals(y)必须返回相同的结果 //随机属性或者自变属性的比较
    //2.5 x.equals(null);的结果是false
    //方法中的Object不要写成Cat，因为框架调的是Object参数
    @Override
    public boolean equals(Object cat){
        if (cat == this){
            return true;
        }
        if (cat instanceof Cat){
            Cat o = (Cat) cat;
            Objects.equals(o.name,name);
            //第一种写法 还是存在问题因为name和color可能为null
            return name.equals(o.name) && color.equals(o.color) && age.equals(o.age);

            //第二钟写法 Objects.equals()的源码 return (a == b) || (a != null && a.equals(b));
            //o.name或者o.color如果为空则直接返回
//            return Objects.equals(o.name,name) && Objects.equals(o.color,color) && Objects.equals(o.age,age);
        }
        //如果不是Cat对象就不存在比较的意义了
        return false;
    }

    public String getName() {
        return name;
    }

    public Cat setName(String name) {
        this.name = name;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Cat setColor(String color) {
        this.color = color;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Cat setAge(Integer age) {
        this.age = age;
        return this;
    }

}
