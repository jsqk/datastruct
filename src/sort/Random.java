package sort;

/**
 * Author: hanzy
 * Date: 2021/9/10, 10:18
 * introduce: 用来生成随机数组，用来检测排序结果
 */
public class Random {

    /**
     * 根据传入的数据，返回一个随机数数组
     * @param n 数组长度
     * @param start 数组内数据的起始值
     * @param end 数组内数据的结束范围， 比如n=5, start=1, end=10，则返回数据大小在（1，10）范围内的一个长度为5的数组
     * @return
     *      int[]
     */
    public static int[] getArray(int n, int start, int end){
        int[] array = new int[n];
        int real_end = end - start;
        java.util.Random random = new java.util.Random();
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(real_end) + start;
        }
        return array;
    }

    public static void main(String[] args) {
        Sorts.show(getArray(8, -4, 10));
    }
}
