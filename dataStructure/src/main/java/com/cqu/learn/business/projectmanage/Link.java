package com.cqu.learn.business.projectmanage;

import lombok.Data;

/**
 * @author Feng
 * @date 2019/9/26
 *
 * 连接两个任务的连接点
 */
@Data
public class Link {
    private int id;
    private int source;
    private int target;
    private RelationType type;
}
