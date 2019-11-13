package com.cqu.learn.utils.digester;

import org.apache.commons.digester3.Digester;
import org.junit.Test;

import java.net.URL;

/**
 * @author Feng
 * @date 2019/10/30
 */
public class DigetserTest {

    @Test
    public void test() {
        URL path = DigetserTest.class.getClassLoader().getResource("digester.xml");
        Digester digester = new Digester();
        digester.setValidating(false);
        // 遇到 department 的节点，就创建 Department 对象
        digester.addObjectCreate("department", Department.class);
        // 当遇到 department 节点时，就使用 setter 方法设置这个对象的字段属性
        digester.addSetProperties("department");
        // 匹配到 department/user 时，创建 User 对象
        digester.addObjectCreate("department/user", User.class);
        // 给 User 设置好自己的属性，当匹配到这个节点时，栈顶的节点就是 User
        // 它的下一个节点就是 Department，现在需要调用 Department 的 addUser 方法
        digester.addSetProperties("department/user");

        // 这就是栈次顶层对象，调用 addUser 方法，参数是 department/user
        digester.addSetNext("department/user", "addUser");
        // 当匹配到 department/extension 时，就调用底层对象的 putExtension 方法，方法参数的个数就是 2 个
        digester.addCallMethod("department/extension", "putExtension", 2);

        // 这里就指定了第一个参数
        digester.addCallParam("department/extension/property-key", 0);
        // 第二个参数
        digester.addCallParam("department/extension/property-value", 1);
        try {
            Department department = digester.parse(path);
            System.out.println(department);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
