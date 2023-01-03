package com.asule.二构造器参数较多时考虑使用构建器;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.EnumSet;

/**
 * @author ASuLe
 * @date 2023/1/3 14:25
 */
public class Dog implements Serializable {

    //final的话set方法就不能用了，但我们希望
    private final Integer id;             //id 是必须的，唯一标识
    private String name;            //name 是可变的 可以为null
    private final String color;           //color是固定的
    private final LocalDateTime birthday; //出生日期，必须且不变
    private Integer user_id;        //主人，可变，可null


    /**
     * 优点：适用于多参数组合，只需要传递需要的参数(构造器如果参数比较多时，不方便枚举全部组合，
     * 只好提供最常用的集中，并提供全参数组合，这时候可能你不得不提供一些非必要的参数，即使不需
     * 要也得传参)，或者，选择使用无参，然后setter方法传值，然后这样就使得参数处于可变状态，
     * 对象的线程就是不安全的了。综上所述，对于使用者非常不方便，Builder模式可以轻松解决这些问题
     *
     * 缺点:需要先创建builder，在某些非常注重性能的地方不合适（例如高并发的时候，多走一层意味着资源要消耗很多）
     * builder只有在参数很多时才合适，但有时候参数是逐渐攀升的，一开始可能就是用的构造器或者静态
     * 方法，后期想改的时候已经在代码中铺开了，再改造可能要重构很多地方，或者就忍受丑陋的不一致现象以及维护成本，
     * 所以需要你提前就知道要使用builder模式
     */
    public static class DogBuilder{

        private Integer id;             //id 是必须的，唯一标识
        private String name;            //name 是可变的 可以为null
        private String color;           //color是固定的
        private LocalDateTime birthday; //出生日期，必须且不变
        private Integer user_id;        //主人，可变，可null

        public Dog build(){
            if (id == null){
                throw new IllegalArgumentException("id is null");
            }
            if (color == null){
                throw new IllegalArgumentException("color is null");
            }
            if (birthday == null){
                throw new IllegalArgumentException("birthday is null");
            }
            return new Dog(id,name,color,birthday,user_id);
        }

        public DogBuilder id(Integer id){
            this.id = id;
            return this;
        }
        public DogBuilder name(String name){
            this.name = name;
            return this;
        }
        public DogBuilder color(String color){
            this.color = color;
            return this;
        }
        public DogBuilder birthday(LocalDateTime birthday){
            this.birthday = birthday;
            return this;
        }
        public DogBuilder userId(Integer user_id){
            this.user_id = user_id;
            return this;
        }
    }

    public Dog() {
        this.id = 0;
        this.color = "white";
        this.birthday = LocalDateTime.now();
    }

    public Dog(Integer id, String name, String color, LocalDateTime birthday) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.birthday = birthday;
    }

    public Dog(Integer id, String color, LocalDateTime birthday) {
        this.id = id;
        this.color = color;
        this.birthday = birthday;
    }

    public Dog(Integer id, String color, LocalDateTime birthday, Integer user_id) {
        this.id = id;
        this.color = color;
        this.birthday = birthday;
        this.user_id = user_id;
    }

    public Dog(Integer id, String name, String color, LocalDateTime birthday, Integer user_id) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.birthday = birthday;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", birthday=" + birthday +
                ", user_id=" + user_id +
                '}';
    }
}
