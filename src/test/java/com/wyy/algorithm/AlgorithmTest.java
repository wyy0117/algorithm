package com.wyy.algorithm;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyy
 * @date 18-10-17
 * @time 下午5:56
 */
public class AlgorithmTest {

    List<Integer> sourceList = new ArrayList<>();

    @Before
    public void prepareData() {
        int count = 54;
        int i = 0;

        while (i++ < count) {
            sourceList.add(i);
        }

        System.out.println("sourceList = " + sourceList);
    }

    @Test
    public void testUpsetList() {
        int time = 0;
        while (time++ < 5) {
            List<Integer> result = new RandomUtil<Integer>().upsetList(sourceList);
            System.out.println("result = " + result);
        }
    }

    @Test
    public void testRandomSubList() {
        int time = 0;
        while (time++ < 5) {
            List<Integer> result = new RandomUtil<Integer>().randomSubList(sourceList, 5);
            System.out.println("result = " + result);
        }
    }
}
