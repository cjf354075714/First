package com.cqu.learn.base.polymorphism;

/**
 * @author Feng
 * @date 2019/9/26
 *
 * 测试传入String，看toString到底是什么样子
 * 实际上调用的还是底层的代码，所有干活的人还是要落实
 */
public class ObjectToString {

    private Object object = null;

    public ObjectToString(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ObjectToString{" +
                "object=" + object +
                '}';
    }
}
