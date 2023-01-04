package com.asule.第2章.第4条通过私有构造器强化不可实例化的能力;


/**
 * @author ASuLe
 * @date 2023/1/4 12:42
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //工具类并不需要实例
        String arg1 = args[0];
        //把工具类改成抽象类并不能够阻止工具类的实例化
        new StringUtilsSon();
        if (StringUtils.isEmpty(arg1)){

        }
    }
}
