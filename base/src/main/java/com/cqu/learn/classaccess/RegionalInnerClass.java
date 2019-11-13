package com.cqu.learn.classaccess;

/**
 * @author Feng
 * @date 2019/11/05
 */
public class RegionalInnerClass {

    {
        @SuppressWarnings("unused")
		class Inner {
            private int i = 0;
        }
    }

    public void fun() {

    }
}
