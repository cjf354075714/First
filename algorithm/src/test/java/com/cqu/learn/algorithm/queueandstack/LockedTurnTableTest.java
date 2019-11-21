package com.cqu.learn.algorithm.queueandstack;

import org.junit.Test;

/**
 * @author Feng
 * @date 2019/10/23
 */
public class LockedTurnTableTest {

    @Test
    public void test() {
        LockedTurnTable lockedTurnTable = new LockedTurnTable();
        String[] deadEnds = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(lockedTurnTable.openLock(deadEnds, target));
    }
}
