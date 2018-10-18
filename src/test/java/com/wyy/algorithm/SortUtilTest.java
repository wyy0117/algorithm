package com.wyy.algorithm;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author wyy
 * @date 18-10-18
 * @time 上午10:03
 */
public class SortUtilTest {

    private int[] numbers = new int[10];

    @Before
    public void prepare() {
        numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 20);
        }
        System.out.println("before sort numbers = " + Arrays.toString(numbers));
    }

    @Test
    public void testBubbleSort1() {
        System.out.println("SortUtilTest.testBubbleSort1");
        int[] numbers = SortUtil.bubbleSort1(this.numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    @Test
    public void testBubbleSort2() {
        System.out.println("SortUtilTest.testBubbleSort2");
        int[] numbers = SortUtil.bubbleSort2(this.numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    @Test
    public void testQuickSort() {
        System.out.println("SortUtilTest.testQuickSort");
        int[] numbers = SortUtil.quickSort(this.numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    @Test
    public void testSelectionSort() {
        System.out.println("SortUtilTest.testSelectionSort");
        int[] numbers = SortUtil.selectionSort(this.numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    @Test
    public void testInsertSort(){
        System.out.println("SortUtilTest.testInsertSort");
        int[] numbers = SortUtil.insertSort(this.numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

}
