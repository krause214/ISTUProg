package istu;

import java.util.ArrayList;

public class MyTree {

    int value;
    MyTree left;
    MyTree right;

    public MyTree(int val, MyTree lef, MyTree rig) {
        value = val;
        left = lef;
        right = rig;
    }

    public MyTree(int val) {
        value = val;
    }

    public static MyTree initTree(int[][] array, int i, int j, int n) {
        MyTree tree = new MyTree(array[i][j]);
        if (i != n - 1){
            tree.left = initTree(array, i + 1, j, n);
            tree.right = initTree(array, i + 1, j + 1, n);
        }
        return tree;
    }

    public void makeSumArray(ArrayList<Integer> sums, MyTree tree, int initSum){
        initSum += tree.value;
        if (tree.left == null || tree.right == null){
            sums.add(initSum);
        }
        else{
            makeSumArray(sums,tree.left,initSum);
            makeSumArray(sums,tree.right,initSum);
        }
    }
    public static MyTree printTree(MyTree tree) {
        if (tree.left == null){
            System.out.print(tree.value + " ");
            return tree;
        }
        else {
            printTree(tree.right);
            printTree(tree.left);
        }
        System.out.print(tree.value + " ");
        return tree;
    }
}
