package search;

/**
 * 顺序查找，顺序表
 */
public class Seq {

    public int[] table; // 用一个数组模拟表

    public Seq(int n){
        table = new int[n];
    }

    public int sel_search(int key){
        for(int i = 0; i < table.length; i++){
            if(table[i] == key){
                return i;
            }
        }
        return -1;
    }

    /**
     * 折半查找
     * @param key
     * @return
     */
    public int search(int key){
        return -1;
    }
}
