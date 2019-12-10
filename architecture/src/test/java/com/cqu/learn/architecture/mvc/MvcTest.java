package com.cqu.learn.architecture.mvc;

import org.junit.Test;

/**
 * @author Feng
 * @date 2019/12/9
 */
public class MvcTest {

    @Test
    public void test() {
        SimpleModel model = new SimpleModel("feng", 23);
        SimpleView view = new SimpleView();
        SimpleController controller = new SimpleController(model, view);
        controller.show();
        controller.setSimpleName("yu");
        controller.show();
    }
}
