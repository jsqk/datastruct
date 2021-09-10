package sort;

/**
 * Author: hanzy
 * Date: 2021/9/10, 9:00
 * introduce: 希尔排序
 * 时间复杂度：最坏复杂度O（n方），在某个范围内，可以达到O（n的1.3次方）
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 * 适用性：仅适用于顺序表，不适用于链表
 */
public class Xier {

    public static void sheel_sort(int[] arr){
        int d, i, j, temp;
        int n = arr.length;
        for(d = n/2; d >= 1; d/=2){ // 变化步长，也就是增量，取法有很多，此处取2
            for(i = d; i < n; i++){
                if(arr[i] < arr[i-d]){
                    temp = arr[i];
                    // 记录后移，查找插入的位置
                    for(j = i-d; j >= 0 && temp < arr[j]; j -= d){
                        arr[j+d] = arr[j];
                    }
                    // 插入
                    arr[j+d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        //1, 3, 10, -2, 2, 5, 6, 2, 9, 24, 25, 0
        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 0
        // 9, 8, 7, 5, 6, 4, 3, 2, 1, 0
//        int[] arr = {9, 8, 7, 5, 6, 4, 3, 2, 1, 0};
        int[] arr = Random.getArray(10, -4, 20);
        System.out.println("生产的随机序列为：");
        Sorts.show(arr);
        Xier.sheel_sort(arr);
        System.out.println("排序后的结果为：");
        Sorts.show(arr);
    }
}
