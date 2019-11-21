package com.cqu.learn.datastructure.business.projectmanage;

/**
 * @author Feng
 * @date 2019/9/26
 *
 * 用于表示任务与任务之间的连线关系
 * FF、FS、SS、SF
 */
public enum RelationType {

    /**
     * FF：完成-完成
     * SS：开始-开始
     * SF：开始-结束
     * FS：结束-开始
     */
    FF, SS, SF, FS;
}
