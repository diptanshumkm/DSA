package trees.example;
import java.util.*;

public class ValidateBst {
    
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x){
            this.data = x;
        }
    }

    public static boolean checkAnswer(ArrayList<Integer> arr){

        for(int i = 0; i <= arr.size()-2; i++){ 
            if (arr.get(i) >= arr.get(i+1)  ) {
                return false;
            }            
        }
        return true;
    }

    public static boolean isValidBst(TreeNode root){
        ArrayList<Integer> arr = new ArrayList<>();
        inOrderTraversal(root, arr);
        return checkAnswer(arr);
    }

    public static void inOrderTraversal(TreeNode root, ArrayList<Integer> arr){
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, arr);
        arr.add(root.data);
        inOrderTraversal(root.right, arr);


    }
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(40);

        root.left = new TreeNode(30);
        root.right = new TreeNode(50);

        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(35);

        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(60);

        root.left.left.left = new TreeNode(15);
        root.left.left.right = new TreeNode(28);

        System.out.println("Is this a valid BST? " + isValidBst(root));

        
    }

}
