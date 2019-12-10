package com.cqu.learn.architecture.mvc;

/**
 * @author Feng
 * @date 2019/12/9
 *
 * MVC 中的 V，实际上是使用的 M 中的属性，不是使用这个对象
 */
public class SimpleView {

    public void show(String name, Integer number) {
        System.out.println(name);
        System.out.println(number);
    }

}
