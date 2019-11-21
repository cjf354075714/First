package com.cqu.learn.designpattern.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Feng
 * @date 2019/11/1
 */
public abstract class ContainerBase {

    private List<Listener> listeners = new LinkedList<>();

    public void start(EventState eventState) {
        if (eventState.equals(EventState.START)) {
            for (Listener listener : listeners) {
                listener.start();
            }
        }
    }
}
