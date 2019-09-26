package com.cqu.learn.business.projectmanage;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Feng
 * @date 2019/9/26
 */
@Data
public class Task {
    private int id;
    private int duration;
    private Calendar startDate;
    private Calendar endDate;
}
