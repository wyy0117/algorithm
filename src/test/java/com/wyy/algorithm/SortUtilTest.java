package com.wyy.algorithm;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wyy
 * @date 18-10-18
 * @time 上午10:03
 */
public class SortUtilTest {

    private int[] numbers = new int[10];
    private Random random = new Random();

    @Before
    public void prepare() {
        numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(20);
        }
        System.out.println("before sort numbers = " + Arrays.toString(numbers));
    }

    @Test
    public void testBubbleSort1() {
        System.out.println("SortUtilTest.testBubbleSort1");
        SortUtil.bubbleSort1(numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    @Test
    public void testBubbleSort2() {
        System.out.println("SortUtilTest.testBubbleSort2");
        SortUtil.bubbleSort2(numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    @Test
    public void testQuickSort() {
        System.out.println("SortUtilTest.testQuickSort");
        SortUtil.quickSort(numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    @Test
    public void testSelectionSort() {
        System.out.println("SortUtilTest.testSelectionSort");
        SortUtil.selectionSort(numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    @Test
    public void testInsertSort() {
        System.out.println("SortUtilTest.testInsertSort");
        SortUtil.insertSort(numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    @Test
    public void testShellSort() {
        System.out.println("SortUtilTest.testShellSort");
        SortUtil.shellSort(numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));

    }

}
