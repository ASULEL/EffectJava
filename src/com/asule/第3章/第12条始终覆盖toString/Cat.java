package com.asule.第3章.第12条始终覆盖toString;

import java.util.Objects;

/**
 * @author ASuLe
 * @date 2023/1/4 16:58
 */
public class Cat {
    private String name;
    private String color;
    private Integer age;
    private String no;

    public String getNo() {
        return no;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", no='" + no + '\'' +
                '}';
    }

    public Cat setNo(String no) {
        this.no = no;
        return this;
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
