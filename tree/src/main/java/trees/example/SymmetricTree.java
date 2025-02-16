package trees.example;
import java.util.*;

public class SymmetricTree {
    
    public static class TreeNode {
        TreeNode left;        
        TreeNode right;
        int data;

        public TreeNode(int x){
            this.data = x;
        }
    }

    public static boolean isSymmetric(TreeNode root){
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();

        leftQueue.add(root.left);
        rightQueue.add(root.right);

        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            
            TreeNode leftNode = leftQueue.poll();
            TreeNode rightNode = rightQueue.poll();
            
            if (leftNode==null && rightNode==null) {
                continue;
            }
            if (leftNode==null || rightNode==null) {
               return false;
            }
            if (leftNode.data != rightNode.data) {
                return false;
            }

            leftQueue.add(leftNode.left);
            leftQueue.add(leftNode.right);
            rightQueue.add(rightNode.right);
            rightQueue.add(rightNode.left);
        }
        return true;
    }


    public static int nodeCount(TreeNode root){
        if (root == null) {
            return 0;
        }    
        int leftCount = nodeCount(root.left);
        int rightCount = nodeCount(root.right);
        return 1+leftCount+rightCount;
    }

    public static int sumOfNode(TreeNode root){
        
        if (root==null) {
            return 0;
        }

        int leftSum = sumOfNode(root.left);
        int rightSum = sumOfNode(root.right);

        return root.data+leftSum+rightSum;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(40);

        root.left = new TreeNode(30);
        root.right = new TreeNode(30);
        
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(35);
        root.right.left = new TreeNode(35);
        root.right.right = new TreeNode(25);
        
        root.left.left.left = new TreeNode(15);
        root.left.left.right = new TreeNode(28);
        root.right.right.left = new TreeNode(28);
        root.right.right.right = new TreeNode(15);
        
        root.left.right.left = new TreeNode(45);
        root.left.right.right = new TreeNode(60);
        root.right.left.left = new TreeNode(60);
        root.right.left.right = new TreeNode(45);


        // Tree is Symmetric or not
        System.out.println(isSymmetric(root));

        // Count node of a tree
        int result = nodeCount(root);
        System.out.println();
        System.out.println(result);


        // Sum of all node
        System.out.println(sumOfNode(root));
    }
}
