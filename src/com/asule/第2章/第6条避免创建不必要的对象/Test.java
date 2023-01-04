package com.asule.第2章.第6条避免创建不必要的对象;

/**
 * 问题1.重用单个对象，不要在每次需要的时候就创建一个相同功能的新对象
 * 问题2.不要频繁自动拆箱装箱(Short Long等都有这种问题)
 * 问题3.小对象的创建和回收实际上是很快速的，有时候为了代码更清晰和可维护，我们会
 * 适当做妥协，这一点根据不同团队的成员实力情况，各有不同。
 *
 * @author ASuLe
 * @date 2023/1/4 13:12
 */
public class Test {
    public static void main(String[] args) {
        //问题1
        //jvm会帮我们去优化，a1和a2指向的是同一个对象
        String a1 = "a";
        String a2 = "a";
        System.out.println(a1 == a2);

        //a3的写法会创建不必要的对象出来
        //创建了不必要的对象，消耗了更多的资源
        String a3 = new String("a");
        System.out.println(a1 == a3);


        System.out.println("----------------------------------------------------------------------------");
        //问题2：
        //自动拆箱
        //正常情况是 int b = a.intValue();
        //jdk 1.5之后jvm优化了
        Integer a = 13;
        int b = a;
        //a = Integer.valueOf(154);这里创建了一个新的对象
        a = 154;
        for (Integer m = 0; m < 100; m++) {
            //对于Integer m而言,在循环中每次都要创建一个新的Integer对象
            //如何优化？把Integer改成int
            //int是一个值，而Integer是一个对象，一个值肯定比一个对象占用的资源要小
            System.out.print(m + " ");
        }

        System.out.println("----------------------------------------------------------------------------");
        //m < a 实际上是执行 m < a.intValue() 每一次都会去拆箱
        //我们要避免这种情况
        //问题:如何优化？
        //拿int存a的值，那每一次的比较就不会拆箱了
        //int m1 = a; for (short m = 0; m < m1; m++) {
        for (short m = 0; m < a; m++) {
            System.out.print(m + " ");
        }
        System.out.println("----------------------------------------------------------------------------");

        //问题3
        int a11 = 13;
        int b11 = 322;
        int tmp = a11;
        a11 = b11;
        b11 = tmp;
        //交换也可以这样写
        //这种方式节省了一个tmp对象
//        a11 = a11 + b11;
//        b11 = a11 - b11;
//        a11 = a11 - b11;
        System.out.println(a11);
        System.out.println(b11);

    }
}
