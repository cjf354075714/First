package com.cqu.learn.architecture.mvc;

/**
 * @author Feng
 * @date 2019/12/9
 *
 * MVC 中的 M
 */
public class SimpleModel {
    private String name;
    private Integer number;

    public SimpleModel() {
    }

    public SimpleModel(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "SimpleModel{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
