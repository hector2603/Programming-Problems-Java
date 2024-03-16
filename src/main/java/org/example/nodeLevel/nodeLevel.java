package org.example.nodeLevel;

public class nodeLevel {

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static long nodeLevel(BinaryTreeNode<Integer> root,int node)
    {

        return searchLevel(root, node, 0);

    }

    public static long searchLevel(BinaryTreeNode<Integer> tree , int node, long level){

        if(tree.data == node){
            return level + 1;
        }

        if(tree.left != null){
            return searchLevel(tree.left, node, level+1);
        }else if(tree.right != null){
            return searchLevel(tree.right, node, level+1);
        }else{
            return 0;
        }


    }

}
