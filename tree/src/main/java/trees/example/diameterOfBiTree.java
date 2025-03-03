package trees.example;

public class diameterOfBiTree {
    
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            this.data = x;
        }
    }

    static int diameter = 0;
    public static int diameterOfBT(TreeNode root){
        checkHeight(root);
        return diameter;

    }

    public static int checkHeight(TreeNode root){
        if (root == null) {
            return 0;
        }

        int leftHeight = checkHeight(root.left);
        int rightHeight = checkHeight(root.right);

        diameter = Math.max(diameter, leftHeight+rightHeight);

        return Math.max(leftHeight, rightHeight)+1;
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        System.out.println(diameterOfBT(root));

    }
}
