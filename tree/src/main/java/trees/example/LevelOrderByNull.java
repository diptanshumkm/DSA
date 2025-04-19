package trees.example;

import java.util.*;

public class LevelOrderByNull {
    
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;

        }
        
    }
    
    public static void levelOrder(TreeNode root){
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            
            TreeNode x = q.poll();
            
            if(x == null){
                System.out.println();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }else{
                System.out.print(x.data + " ");
                
                if(x.left != null){q.add(x.left);}
                if(x.right != null){q.add(x.right);}
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
         TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);
        
        levelOrder(root);
        
        
    }


}
