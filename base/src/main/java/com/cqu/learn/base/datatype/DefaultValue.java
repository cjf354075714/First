package com.cqu.learn.base.datatype;

/**
 * @author Feng
 * @date 2019/9/26
 *
 * 测试java所有基本数据类型的默认值
 *
 * 显然在声明一个变量时需要赋值，为了避免这样，我声明的是数组
 */
public class DefaultValue {

    private int length = 0;

    /**
     * byte 类型的默认值是0
     */
    private byte[] bytes = null;
    /**
     * short 类型的默认值是0
     */
    private short[] shorts = null;
    /**
     * int 类型的默认值是0
     */
    private int[] ints = null;

    /**
     * long 类型的默认值是0l
     */
    private long[] longs = null;

    /**
     * float 类型的默认值是0.0f
     */
    private float[] floats = null;

    /**
     * double 类型的默认值是0.0d
     */
    private double[] doubles = null;

    /**
     * char 类型的默认值是 null
     */
    private char[] chars = null;

    public DefaultValue(int num) {
        length = num;
        bytes = new byte[length];
        shorts = new short[length];
        ints = new int[length];
        longs = new long[length];
        floats = new float[length];
        doubles = new double[length];
        chars = new char[length];
    }

    public void print() {
        for (int i = 0; i < length; i++) {
            System.err.println(bytes[i]);
            System.err.println(shorts[i]);
            System.err.println(ints[i]);
            System.err.println(longs[i]);
            System.err.println(floats[i]);
            System.err.println(doubles[i]);
            System.err.println(chars[i]);
        }
    }
}
