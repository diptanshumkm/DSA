// package trees.example;

// import static org.junit.Assert.assertTrue;
// import static org.junit.Assert.assertFalse;

// import org.junit.Test;
// import trees.example.SymmetricTree.TreeNode;


// public class SymmetricTreeTest {

//     @Test
//     public void testSymmetricTree() {
//         // Create a symmetric tree
//         TreeNode root = new TreeNode(1);
//         root.left = new TreeNode(2);
//         root.right = new TreeNode(2);
//         root.left.left = new TreeNode(3);
//         root.left.right = new TreeNode(4);
//         root.right.left = new TreeNode(4);
//         root.right.right = new TreeNode(3);

//         assertTrue(SymmetricTree.isSymmetric(root));  // Call static method directly
//     }

//     @Test
//     public void testAsymmetricTree() {
//         // Create an asymmetric tree
//         TreeNode root = new TreeNode(1);
//         root.left = new TreeNode(2);
//         root.right = new TreeNode(2);
//         root.left.right = new TreeNode(3);
//         root.right.right = new TreeNode(3);

//         assertFalse(SymmetricTree.isSymmetric(root));  // Call static method directly
//     }

//     @Test
//     public void testAsymmetricTree2(){
//         TreeNode root = new TreeNode(1);
//         root.left = new TreeNode(2);
//         root.right = new TreeNode(2);
//         root.left.right = new TreeNode(3);
//         root.right.right = new TreeNode(3);

//         assertFalse(SymmetricTree.isSymmetric(root));
//     }
// }
