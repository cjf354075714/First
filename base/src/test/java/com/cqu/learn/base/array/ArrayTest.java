package com.cqu.learn.base.array;

import org.junit.Test;

/**
 * @author Feng
 * @date 2019/10/21
 */
public class ArrayTest {

    @Test
    public void test() {
        char[][] s = {
                {'a', 'b'},
                {'c', 'd'},
                {'e', 'f'}
        };
        System.err.println(s[2][1]);
    }

    @Test
    public void test1() {
        Object array = new int[]{1, 2};
        System.out.println(array.getClass().isArray());
    }

    /**
     * 该方法证明了，int 这类基本属性的类对象，是不能够和对象的类对象进行继承判断
     */
    @Test
    public void test2() {
        int[] temp = new int[]{1, 2};
        Object[] objects = new Object[]{};
        System.out.println(Number.class.isAssignableFrom(int.class));
    }

    @Test
    public void test3() {
        System.out.println(int.class == Integer.class);
    }

    /**
     * getComponentType() 方法将返回数组对象的所属类型
     */
    @Test
    public void test4() {
        Object o = new Object();
        System.out.println(o.getClass().getComponentType());
        Object[] os = new Object[]{};
        System.out.println(os.getClass().getComponentType());
    }
}
