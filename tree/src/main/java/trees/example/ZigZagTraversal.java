package trees.example;

import java.util.*;


public class ZigZagTraversal {
    
    public static class TreeNode {
        int data;
        TreeNode left, right;
    
        TreeNode(int data) {
            this.data = data;
        }
    }


    public static ArrayList<ArrayList<Integer>> zigZagTraversal(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        boolean flag = true; //The traversal is left to right

        queue.add(root);

        while (!queue.isEmpty()) {
            
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            Stack<Integer> stack = new Stack<>();

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();

                if (flag ) {
                    level.add(node.data);
                }else{
                    stack.push(node.data);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            flag = !flag;

            while (!stack.isEmpty()) {
                level.add(stack.pop());             
            }

            result.add(level);
        }

        return result;

    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        
        ArrayList<ArrayList<Integer>> zigzag = zigZagTraversal(root);
        System.out.println(zigzag);
    }

}

