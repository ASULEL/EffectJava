package com.asule.第2章.第1条静态方法替代构造器;

import java.io.Serializable;

/**
 * @author ASuLe
 * @date 2023/1/3 13:07
 */
public class Cat implements Serializable {

    private static final Cat cat = new RagDollCat();

    private Integer id;
    private String name;
    private String color;

    /**
     * 第一个优势：静态工厂模式与构造器不同的第一大优势在于，静态工厂模式有名称
     * 即getInstance()这个名称可以按照自己的想法去进行更改,例如目前是单例模式，我可以将getInstance()方法名改成Singleton()单例模式，见名知意
     * 第四个优势：结合第一个优势理解,所返回对象的类可以随着每次调用而发生变化，这取决于静态工厂方法的参数值
     *
     * 第二个优势:不必每次调用它们的时候都创建一个新对象
     *
     * 第三个优势:静态方法可以返回子类型
     * 注意:构造器不能return 所以只能返回自身的实例，且必定是新的实例 即new出来的实例
     * 并且构造器去判断name == null 如果不成立不能return null只能抛出异常
     * @param name
     * @return
     */
    public static Cat getInstance(String name){
        if (name == null){
            return null;
        }
        return cat;
    }


    /**
     * 第一个优势 ① :这里无参构造变成私有类型，也就是说外部调用不了无参构造，只能内部调用无参构造
     */
    protected Cat() {
    }

    /**
     * 第五个优势：构造器之间调用有顺序要求，但是静态方法之间无要求
     * return cat可以根据自己的需要返回
     * @param name
     * @return
     */
    public static Cat getInstance2(String name){
        Cat cat = getInstance(name);
        if (name.equals("小咪")){
            return cat;
        }
        return cat;
    }


    /**
     * 第五个优势：构造器之间调用有顺序要求，但是静态方法之间无要求
     * @param id
     */
    public Cat(Integer id) {
        this();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
