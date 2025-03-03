package trees.example;

public class LowestComnAncestor {
    
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.data =x;
        }
    }

    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if (root==null || root == p  || root==q) {
            return root;
        }

        TreeNode leftLca = lca(root.left, p, q);
        TreeNode rightLca = lca(root.right, p, q);

        if (leftLca != null && rightLca != null) {
            return root;
        }
        
        if (leftLca == null && rightLca == null) {
            return null;
        }

        return (leftLca != null) ? leftLca : rightLca;

    }

    public static void main(String[] args) {
        // Constructing the binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
 
        TreeNode p = root.left.left;  // Node 6
        TreeNode q = root.left.right.right; // Node 4
 
        TreeNode lca = lca(root, p, q);

        if (lca!=null) {
            System.out.println("LCA of "+ p.data + " and " + q.data +" is " + lca.data);
        }else{
            System.out.println("No LCA found");
        }

    }

}
