import java.util.*;

public class test {
    
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data){
            this.data = data;
        }

    }

    public static ArrayList<ArrayList<Integer>> zigZag2(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        boolean flag = true;

        if (root==null) {
            return answer;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            
            ArrayList<Integer> level = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            int size = queue.size();

            for(int i =0; i < size; i++){
                TreeNode node = queue.poll();

                if (flag) {
                    level.add(node.data);
                }else{
                    stack.push(node.data);
                }

                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
            flag = !flag;

            while (!stack.isEmpty()) {
                level.add(stack.pop());
            }

            answer.add(level);
        }
        return answer;
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Adding a new layer
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(2);

        ArrayList<ArrayList<Integer>> finall = zigZag2(root);
        System.out.println(finall);
    }

}   
