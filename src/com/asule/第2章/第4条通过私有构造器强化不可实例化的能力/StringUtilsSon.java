package com.asule.第2章.第4条通过私有构造器强化不可实例化的能力;

/**
 * 问题:仅仅声明为抽象类来强制该类不可以被实例化是不行的
 * 原因：会误导用户，以为StringUtils这个抽象类是专门为继承而设计的，
 * 会让用户误导用户StringUtils需要实例化
 * 回答：声明为抽象类并不能完全组织实例化，反而可能会被调用者以为需要子类
 * 如果需要更强的安全性，可以在构造器中抛出异常
 * @author ASuLe
 * @date 2023/1/4 13:01
 */
public class StringUtilsSon extends StringUtils{
}
