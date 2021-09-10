package sort;

import java.util.Arrays;

/**
 * 插入排序，包括三个方法。
 * 稳定性：稳定
 * 空间复杂度：O（1）
 * 时间复杂度：平均为O（n^2)
 */
public class Sorts {

    /**
     * 插入排序(普通)，
     * 算法思想：每次将一个待排序的记录按其关键字的大小插入到前面已经排好序的子序列中，知道全部记录插入完成。
     * @param arr
     */
    public static void insert_sort(int[] arr){
        int i, j, temp;
        for(i = 1; i < arr.length; i++){
            if(arr[i] < arr[i-1]){
                temp = arr[i];
                for(j = i-1; j >= 0 && arr[j] > temp; j--){ // 元素后移
                    arr[j+1] = arr[j];
                }
                arr[j+1] = temp;
            }
        }
    }

    /**
     * 插入排序（带哨兵）
     * 将‘哨兵’存放在0位置，每次循环可以减少一次判断。
     * @param arr
     */
    public static void insert_sort_sentry(int[] arr){
        int i, j;
        for(i = 2; i < arr.length; i++){
            arr[0] = arr[i]; // 0号位置不放元素，暂存要排序的数字
            for(j = i-1; arr[0] < arr[j]; j--){ // 元素后移
                arr[j+1] = arr[j];
            }
            arr[j+1] = arr[0];
        }
    }

    /**
     * 插入排序（优化）
     * 在比较大小的时候使用【折半查找】的方法，可以对算法进行进一步优化。
     * @param arr
     */
    public static void insert_sort_opt(int[] arr){
        int i, j, temp;
        int left = 0, right = 0, now = 1, mid;
        for(i = 1; i < arr.length; i++){
            temp = arr[i];
            left = 0; right = i-1;
            // 折半查找
            while (left <= right){
                mid = (left+right)/2;
                if(arr[mid] > temp){
                    right = mid-1;
                }else{ // 删除相等时候的情况，保证排序的稳定性
                    left = mid+1;
                }
            }
            // 元素后移
            for(j = i-1; j >= right+1; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }

    public static void show(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        //"1, 3, 10, -2, 5, 6, 2, 9, 24, 25, 0"
        int[] arr = {1, 3, 10, -2, 5, 6, 2, 9, 24, 25, 0};
        Sorts.insert_sort(arr);
        Sorts.show(arr);

        // 带哨兵的插入排序测试，开始的0不在排序范围内，减少了一次比较
        int[] arr1 = {0, 1, 3, 10, -2, 5, 6, 2, 9, 24, 25, 0};
        Sorts.insert_sort_sentry(arr1);
        Sorts.show(arr1);

        // 优化后的插入排序，在匹配时采用折半查找的方法，理论上可以减少运行时间
        int[] arr2 = {1, 3, 10, -2, 2, 5, 6, 2, 9, 24, 25, 0};
        Sorts.insert_sort_opt(arr2);
        Sorts.show(arr2);
    }
}
