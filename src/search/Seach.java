package search;

public class Seach {
    /**
     * 折半查找，又叫二分查找，此处默认传入的为从小到大的数组。
     * 要求：
     *  被查找的表是有序的，而且只能是顺序表。
     * @param key
     * @return
     */
    public static int search(int[] array, int key){
        int left = 0;
        int right = array.length-1;
        int mid;
        while(left <= right){
            mid = (right+left)/2;
            if(array[mid] < key){
                left = mid+1;
            }else if(array[mid] > key){
                right = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 10, 12}; // 注意，折半查找必须是有序表！
        System.out.println(Seach.search(array, 7)+1);
    }
}
