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
        BubbleSort.insertSort(arr);
        for (int i = 0 ;i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void simpleBubbleSort(int [] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        for(int i = 0;i < array.length; i++) {
            int temp;
            for(int j = i + 1; j < array.length -1; j++) {
                if (array[j] < array[i]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //经过一轮循环排序如果有序，则退出循环
    public static void realBubbleSort(int [] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        boolean flag = true;
        for(int i = 0;i < array.length && flag; i++) {
            int temp;
            flag = false;
            for (int j = array.length - 1; j > i; j--){
                if (array[j] < array[j-1]) {
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
        }
    }

    //选择排序
    public static void selectSort(int [] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        for(int i = 0;i < array.length; i++) {
            int minIndex = i;

            for(int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp;
            if (minIndex != i) {
                temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    //插入排序
    public static void insertSort(int [] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        for (int i = 1, j,temp; i < array.length; i++) {
            j = i-1;
            temp = array[i];
            while (j >= 0 && array[j] > temp) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }

    //二分查找
    public static int binSearch(int [] array,int target,int n) {
        int low = 0, high = n, mid;
        while (low <= high) {
            mid =low + (high - low);
            if(array[mid] == target){
                return mid;
            }else if(array[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}