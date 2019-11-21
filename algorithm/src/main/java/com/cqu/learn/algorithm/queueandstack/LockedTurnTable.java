package com.cqu.learn.algorithm.queueandstack;

import java.util.*;

/**
 * @author Feng
 * @date 2019/10/23
 *
 * 问题描述：现在给定一个四位字符串：“0000”
 * 每次只能改变一位，改变的幅度是一个数字，比如 0 -> 1 0 -> 9 等
 * 接着有一串锁定的字符串数组，{"0001", "0908", "1001", "2002"}
 * 当转到这个字符串数组中的一个的时候，就代表着锁定了，就不能转动，表示失败
 * 接着给定一个目标值，"9999"，如果该初始值通过转化，能够得到目标值，返回最短的旋转次数
 * 如果转换不到，则返回 -1
 *
 * 思路，首先是 "0000"，每一位可以向上向下转化，而且有四位，就表示一共有 8 中可能，在不考虑锁的情况下
 * 也就是说，初始位，如果不行，则将这个初始位的后面的 8 个位拿来比较，如果还不行，又将这 8 位的下
 * 面各自 8 位再进行比较，如果出现了锁的位，那么这锁的这一位也就不会再旋转了，因为已经锁死了
 * 在旋转的过程中只有两种情况会退出：
 * 1，找到了指定的位，返回
 * 2，被锁死了，也就是全部的 8 位都被锁死了
 * 接着再讨论如何保证最短的次数的问题，实际上我旋转的方式，是同时向前和同时向后旋转，也就不存在最短路径了
 * BFS 广度优先遍历，在不存在边权重的情况下，一定是最短路径
 */
public class LockedTurnTable {

    public int openLock(String[] deadEnds, String target) {
        Set<String> lockStringSet = new HashSet<>(Arrays.asList(deadEnds));
        if (lockStringSet.contains("0000") || lockStringSet.contains(target)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        Queue<String> tempQueue = new LinkedList<>();
        queue.add("0000");
        int result = 0;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                String temp = queue.poll();
                if (temp.equals(target)) {
                    return result;
                }
                List<String> nextString = this.getAround(temp);
                nextString.forEach((item) -> {
                    if (!lockStringSet.contains(item)) {
                        lockStringSet.add(item);
                        tempQueue.add(item);
                    }
                });
            }
            queue.addAll(tempQueue);
            tempQueue.clear();
            result ++;
        }
        return -1;
    }

    /**
     * 该方法将返回 center 的周围字符串
     * 将返回 8 个字符串
     * @param center 中心字符串
     * @return 8 个字符串组成的 List
     */
    private List<String> getAround(String center) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < center.length(); i++) {
            StringBuilder tempDown = new StringBuilder(center);
            StringBuilder tempUp = new StringBuilder(center);
            char tempChar = center.charAt(i);
            tempDown.setCharAt(i, tempChar == '0' ? '9' : (char) (tempChar - 1));
            tempUp.setCharAt(i, tempChar == '9' ? '0' : (char) (tempChar + 1));
            result.add(tempDown.toString());
            result.add(tempUp.toString());
        }
        return result;
    }
}
