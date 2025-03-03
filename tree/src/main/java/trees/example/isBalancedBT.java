package trees.example;

public class isBalancedBT {
    
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            this.data = x;
        }
    }

    public static boolean isBalancedBinaryTree(TreeNode root){

        if (checkHeight(root) != 1) {
            return false;
        }else{
            return true;
        }
    }

    public static int checkHeight(TreeNode root){

        if (root == null) {return 0;}
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1){return -1;}

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {return -1;}

        if (Math.abs(rightHeight-leftHeight) > 1) {
            return -1;
        }
        return 1+Math.max(leftHeight, rightHeight);
    }


    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(54);
        root.left.left.left.left = new TreeNode(554);
        System.out.println(isBalancedBinaryTree(root));  


    }
}
