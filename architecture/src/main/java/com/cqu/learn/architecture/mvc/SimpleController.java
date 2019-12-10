package com.cqu.learn.architecture.mvc;

/**
 * @author Feng
 * @date 2019/12/9
 *
 * MVC 中的 C
 */
public class SimpleController {
    private SimpleModel model;
    private SimpleView view;

    public SimpleController(SimpleModel model, SimpleView view) {
        this.model = model;
        this.view = view;
    }

    public void setSimpleName(String name) {
        model.setName(name);
    }

    public void setSimpleNumber(Integer number) {
        model.setNumber(number);
    }

    public String getSimpleName() {
        return model.getName();
    }

    public Integer getSimpleNumber() {
        return model.getNumber();
    }

    public void show() {
        view.show(model.getName(), model.getNumber());
    }
}
