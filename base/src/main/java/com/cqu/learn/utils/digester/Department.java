package com.cqu.learn.utils.digester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Feng
 * @date 2019/10/30
 */
public class Department {
    private String name;
    private String code;
    private Map<String, String> extension = new HashMap<>();
    private List<User> users = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void putExtension(String name, String value) {
        this.extension.put(name, value);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", extension=" + extension +
                ", users=" + users +
                '}';
    }
}
