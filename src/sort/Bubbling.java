package sort;

import java.util.Arrays;

/**
 * Author: hanzy
 * Date: 2021/9/11, 10:48
 * introduce: 冒泡排序
 */
public class Bubbling {

    /**
     * 冒泡排序之顺序排
     * @param array
     */
    public static void bub_sort_order(int[] array){
        for(int i = 0; i < array.length-1; i++){
            boolean flag = false; // 是否发生交换？
            for(int j = array.length-1; j > i; j--){
                if(array[j-1] > array[j]){
                    swap(array, j-1, j);
                    flag = true;
                }
            }
            if(!flag){ // 没有交换
                return ;
            }
        }
    }
    /**
     * 冒泡排序之逆序排
     * @param array
     */
    public static void bub_sort_desc(int[] array){
        for(int i = 0; i < array.length-1; i++){
            boolean flag = false; // 是否发生交换？
            for(int j = array.length-1; j > i; j--){
                if(array[j-1] < array[j]){
                    swap(array, j-1, j);
                    flag = true;
                }
            }
            if(!flag){ // 没有交换
                return ;
            }
        }
    }

    /**
     * 交换数组中m、n位置的元素
     * @param arr
     * @param m
     * @param n
     */
    private static void swap(int[] arr, int m, int n){
        int t = arr[m];
        arr[m] = arr[n];
        arr[n] = t;
    }

    public static void main(String[] args) {
        int[] arr = Random.getArray(100000, -100000, 100000);
        System.out.println("排序前");
        Sorts.show(arr);
        Bubbling.bub_sort_desc(arr);
        System.out.println("排序后");
        Sorts.show(arr);
    }
}
