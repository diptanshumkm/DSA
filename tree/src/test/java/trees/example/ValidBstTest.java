// package trees.example;

// import trees.example.ValidateBst.TreeNode;

// import static org.junit.Assert.assertFalse;
// import static org.junit.Assert.assertTrue;

// import org.junit.Test;

// public class ValidBstTest {
    
//     @Test
//     public void testValidBst() {
//         TreeNode root = new TreeNode(40);

//         root.left = new TreeNode(30);
//         root.right = new TreeNode(50);

//         root.left.left = new TreeNode(25);
//         root.left.right = new TreeNode(35);

//         root.right.left = new TreeNode(45);
//         root.right.right = new TreeNode(60);

//         root.left.left.left = new TreeNode(15);
//         root.left.left.right = new TreeNode(28);

//         assertTrue(ValidateBst.isValidBst(root));
//     }

//     @Test
//     public void testInValidBst() {
//         TreeNode root = new TreeNode(40);

//         root.left = new TreeNode(30);
//         root.right = new TreeNode(50);

//         root.left.left = new TreeNode(25);
//         root.left.right = new TreeNode(35);
        
//         root.right.left = new TreeNode(45);
//         root.right.right = new TreeNode(60);

//         root.left.left.left = new TreeNode(15);
//         root.left.left.right = new TreeNode(28);

//         root.left.right.right = new TreeNode(38);

//         assertFalse(ValidateBst.isValidBst(root));
//     }
// }
