package com.cqu.learn.base.classaccess;

/**
 * @author Feng
 * @date 2019/11/05
 *
 * 成员内部类和父类之间的关系
 */
public class MemberInnerClass {

    private int parentId = 0;
    public int common = 0;

    public class InnerClass {

        public int common = 1;
        public void print() {
            System.out.println(parentId);
        }
    }
}
