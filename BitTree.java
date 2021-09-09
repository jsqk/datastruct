package tree.bitTree;

import java.util.Arrays;

/**
 * encode:utf-8
 */
public class BitTree {

    public static final int SUFANDIN= 0; // 使用后序与中序构造
    public static final int PREANDIN= 1; // 使用前序与中序构造

    private BitNode root;

    public BitNode getRoot() {
        return root;
    }

    public BitTree(char[] order, char[] ino, int flag){
        root = new BitNode();
        switch (flag){
            case SUFANDIN: root = bulidBySufAndIn(order, ino); break;
            case PREANDIN: root = bulidByPreAndIn(order, ino); break;
            default:
                System.out.println("请输入正确的标识符！");
        }
    }

    /**
     * 用一个先序序列和一个中序序列构造出一颗二叉树
     * 但有一些限制: 序列中不能出现同样的数字，因为此构造使用数字而非对象来构造二叉树，若数字相同，可能会出现BUG。
     * 同样的，先序序列和后序序列也必须正确，毕竟错误的序列构造不出正确的二叉树。
     * @param pre
     * @param mid
     */
    private BitNode bulidByPreAndIn(char[] pre, char[] mid){
        if(pre.length == 0 || mid.length == 0){
            return null;
        }
        // 先序序列的第一个结点是二叉树的根结点
        BitNode node = new BitNode();
        node.data = pre[0];

        // 从中序序列中取到根结点的下标，可以将中序序列分成两个子序列，分别是左右子树的序列
        int index = getIndex(0, mid.length, mid, node.data);

        // 构建左子树
        node.leftChild = bulidByPreAndIn(Arrays.copyOfRange(pre, 1, index+1),
                                Arrays.copyOfRange(mid, 0, index));
        // 构建右子树
        node.rightChild = bulidByPreAndIn(Arrays.copyOfRange(pre, index+1, pre.length),
                Arrays.copyOfRange(mid, index+1, mid.length));

        return node;
    }


    private BitNode bulidBySufAndIn(char[] suf, char[] mid){
        if(suf.length == 0 || mid.length == 0){
            return null;
        }
        // 后序序列的最后一个结点是二叉树的根结点
        BitNode node = new BitNode();
        node.data = suf[suf.length-1];

        // 从中序序列中取到根结点的下标，可以将中序序列分成两个子序列，分别是左右子树的序列
        int index = getIndex(0, mid.length, mid, node.data);

        // 构建左子树
        node.leftChild = bulidBySufAndIn(Arrays.copyOfRange(suf, 0, index),
                Arrays.copyOfRange(mid, 0, index));
        // 构建右子树
        node.rightChild = bulidBySufAndIn(Arrays.copyOfRange(suf, index, suf.length-1),
                Arrays.copyOfRange(mid, index+1, mid.length));

        return node;
    }

    private int getIndex(int start, int end, char[] mid, char data){
        for(int i = start; i < end; i++){
            if(mid[i] == data){
                return i;
            }
        }
        return -1;
    }

    /**
     * 后序遍历一颗二叉树
     * @param node
     */
    public void suf(BitNode node){
        if(node != null){
            // 先输出左孩子
            suf(node.leftChild);
            // 再输出右孩子
            suf(node.rightChild);
            // 最后输出根结点的值
            System.out.print(node.data + " ");
        }
    }

    /**
     * 中序遍历一颗二叉树
     * @param node
     */
    public void ino(BitNode node){
        if(node != null){
            ino(node.leftChild);
            System.out.print(node.data + " ");
            ino(node.rightChild);
        }
    }

    /**
     * 先序遍历一颗二叉树
     * @param node
     */
    public void pre(BitNode node){
        if(node != null){
            // 先输出根结点的值
            System.out.print(node.data + " ");
            // 再输出左孩子
            pre(node.leftChild);
            // 最后输出右孩子
            pre(node.rightChild);
        }
    }

    public static void main(String[] args) {
        char[] pre = {'D', 'A', 'E', 'F', 'B', 'C', 'H', 'G', 'I'};
        char[] ino = {'E', 'A', 'F', 'D', 'H', 'C', 'B', 'G', 'I'};
        char[] suf = {'E', 'F', 'A', 'H', 'C', 'I', 'G', 'B', 'D'};
        BitTree bitTree = new BitTree(pre, ino, BitTree.PREANDIN);
        System.out.println("先序遍历为：");
        bitTree.pre(bitTree.getRoot());
        System.out.println("\n后序遍历为：");
        bitTree.suf(bitTree.getRoot());
        System.out.println("\n中序遍历为：");
        bitTree.ino(bitTree.getRoot());
    }
}
