package trees.example;

import java.util.LinkedList;
import java.util.Queue;

public class BTmaxPathSum {
    
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            this.data = x;
        }
    }

    static int maxSum = 0;
    public static int maxPathSum(TreeNode root){

        if (root == null ) {return 0;}
        int leftSum = maxPathSum(root.left);
        int rightSum = maxPathSum(root.right);
        maxSum = Math.max(maxSum, root.data+leftSum+rightSum);

        return root.data + Math.max(leftSum, rightSum);
    }

    static void levelTraversal(TreeNode root){

        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode dummy = queue.poll();
            System.out.print(dummy.data + " ");
            if (dummy.left!=null) {
                queue.add(dummy.left);
            }
            if (dummy.right!=null) {
                queue.add(dummy.right);
            }
        }


    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

    //    int x = maxPathSum(root);
    //    System.out.println(maxSum);

       levelTraversal(root);
    }

}
