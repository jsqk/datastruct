package sort;

/**
 * Author: hanzy
 * Date: 2021/9/11, 19:17
 * introduce: 快速排序
 */
public class Quick {


    public static void sort(int[] arr){
        quick_sort(arr, 0, arr.length-1);
    }

    /**
     * 使用递归方式进行快速排序，每次划分，使得基址左侧全部小于基值，右侧全部大于基值。
     * 一次划分之后，分解为两个小问题，划分到最后，无需合并，数组归于有序。
     * @param arr
     * @param start
     * @param end
     */
    private static void quick_sort(int[] arr, int start, int end){
        if(start < end){ // 递归出口
            // 1. 划分基准，取到基址的下标
            int pivot_pos = getPartition(arr, start, end);
            // 2. 划分左侧
            quick_sort(arr, start, pivot_pos-1);
            // 3. 划分右侧
            quick_sort(arr, pivot_pos+1, end);
        }
    }

    private static int getPartition(int[] arr, int left, int right){
        int pivot = arr[left];
        /*
        * 思考：为什么不能取等于？
        *   因为会报错(●ˇ∀ˇ●)
        *   因为在最后的pivot，也就是left和right相等的位置，在循环中并非，除非相等，否则它总会大于或小于基准值，而在调换之后，调上来的
        * 同样是
        * */
        while (left < right){
            while (left < right && arr[right] >= pivot){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[right] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = Random.getArray(100, -100, 1000);
//        int[] arr = {2, 3, 7, 5, 1, 0};
        System.out.println("排序前");

        Basic.show(arr);
        Quick.sort(arr);
        System.out.println("排序后");
        Basic.show(arr);
        System.out.println("是否顺序: " + Basic.isOrder(arr));
    }
}
