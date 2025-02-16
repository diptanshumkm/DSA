package trees.example;
import java.util.*;


public class Traversals 
{
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int key){
            this.data = key;
        }

    }

    static void preorder(TreeNode root){
        if (root!=null) {
            System.out.print(root.data + ", ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void inorder(TreeNode root){
        if (root!=null) {
            inorder(root.left);
            System.out.print(root.data + ", ");
            inorder(root.right);
        }
    }

    static void postorder(TreeNode root){
        if (root!=null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + ", ");            
        }
    }

    static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            
            TreeNode node = queue.poll();
            System.out.print(node.data + ", ");

            if (node.left!=null) {
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }

    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World! kncsjks" );

        TreeNode root = new TreeNode(40);

        root.left = new TreeNode(30);
        root.right = new TreeNode(50);

        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(35);
        
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(60);

        root.left.left.left = new TreeNode(15);
        root.left.left.right = new TreeNode(28);

        root.right.right.left = new TreeNode(55);
        root.right.right.right = new TreeNode(70);

        System.out.println("Pre-order Traversal: ");
        preorder(root);

        System.out.println();

        System.out.println("Inorder Traversal: ");
        inorder(root);

        System.out.println();

        System.out.println("Post-order Traversal: ");
        postorder(root);

        System.out.println();

        System.out.println("Level-order Traversal: ");
        levelOrder(root);
    }
}