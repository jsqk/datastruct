package sort;

/**
 * Author: hanzy
 * Date: 2021/9/11, 11:52
 * introduce:
 */
public class Select {

    public static void sort(int[] arr){
        int min;
        for(int i = 0; i < arr.length-1; i++){
            min = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            Basic.swap(arr, min, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = Random.getArray(8,0, 20);
        System.out.println("排序前");
        Basic.show(arr);
        Select.sort(arr);
        System.out.println("排序后");
        Basic.show(arr);
    }
}
