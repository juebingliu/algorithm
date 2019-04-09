package com.algorithm.sort;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/2/20 18:52
 * @description 冒泡排序 (O(n^2))
 */
public class BubbleSort {

    public static void bubbleSort(int []numbers) {
        int temp = 0;
        for(int i = 0; i<numbers.length;i++){
            for (int j = 0; j<numbers.length-i-1;j++) {
                if(numbers[j] > numbers[j+1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,3,6,8,1,2,4,15};
        BubbleSort.bubbleSort(arr);
        for (int i = 0 ;i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}