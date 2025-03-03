package trees.example;

import java.util.LinkedList;
import java.util.Queue;

public class isCBT {
    
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            this.data = x;
        }
    }

    public static boolean isCbt(TreeNode root){
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean foundNull = false;
        queue.add(root);

        while (!queue.isEmpty()) {
            
            TreeNode currentNode = queue.poll();

            if (currentNode == null) {
                foundNull=true;
            }else{
                if (foundNull) {
                    return false;
                }
                
            queue.add(currentNode.left);
            queue.add(currentNode.right);
        }            
    }

        return true;
}

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(isCbt(root));  // Output: true
    }


}
