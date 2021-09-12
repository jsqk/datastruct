package sort;

/**
 * Author: hanzy
 * Date: 2021/9/12, 11:03
 * introduce: 归并排序
 *  将两个或多个已经有序的序列合并成一个有序序列
 *  算法思路：
 *          每次划分，将无序序列分为两个长度之差<=1的子序列，直到划分为最小 ———— 每个子序列只包含一个元素。
 *          划分结束后，开始对子序列进行合并操作，合并时使之各自有序，最后合并为原先长度的数组，即成为有序序列。
 */
public class Merge {

    private static int[] result_arr;

    public static void sort(int[] arr){
        result_arr = new int[arr.length];
        merge_sort(arr, 0, arr.length-1);
    }

    /**
     * 归并排序
     * @param arr
     * @param left
     * @param right
     */
    private static void merge_sort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left+right) / 2;
            // 左划分
            merge_sort(arr, left, mid);
            // 右划分
            merge_sort(arr, mid+1, right);
            // 归并
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right){
        int i, j, k;
        for(k = left; k <= right; k++){
            result_arr[k] = arr[k];
        }
        /*
        * i指向第一个有序序列的第一个元素，j指向第二个有序序列的第一个元素
        * */
        for(i=left, j=mid+1, k=i; i <= mid && j <= right; k++){
            // 较小值复制到原数组中
            if(result_arr[i] <= result_arr[j]){
                arr[k] = result_arr[i++];
            }else{
                arr[k] = result_arr[j++];
            }
        }
        // 收尾
        while (i <= mid){
            arr[k++] = result_arr[i++];
        }
        while (j <= right){
            arr[k++] = result_arr[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = Random.getArray(1000, -1000, 1000);
        System.out.println("排序前");
        Basic.show(arr);
        Merge.sort(arr);
        System.out.println("排序后");
        Basic.show(arr);
        System.out.println("是否顺序: " + Basic.isOrder(arr));
    }
}
