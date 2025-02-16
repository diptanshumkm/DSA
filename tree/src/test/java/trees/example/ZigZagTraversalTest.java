package trees.example;

import static org.junit.Assert.assertEquals;
import trees.example.ZigZagTraversal.TreeNode;;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

public class ZigZagTraversalTest {

    @Test
    public void testEmptyTree() {
        TreeNode root1 = null;
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, ZigZagTraversal.zigZagTraversal(root1));
    }

    @Test
    public void testSingleNode() {
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> level1 = new ArrayList<>();
        level1.add(1);
        expected.add(level1);
        assertEquals(expected, ZigZagTraversal.zigZagTraversal(root2));
    }

    @Test
    public void testLeftSkewedTree() {
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.left.left.left = new TreeNode(4);
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> level1 = new ArrayList<>();
        level1.add(1);
        List<Integer> level2 = new ArrayList<>();
        level2.add(2);
        List<Integer> level3 = new ArrayList<>();
        level3.add(3);
        List<Integer> level4 = new ArrayList<>();
        level4.add(4);
        expected.add(level1);
        expected.add(level2);
        expected.add(level3);
        expected.add(level4);
        assertEquals(expected, ZigZagTraversal.zigZagTraversal(root3));
    }

    @Test
    public void testRightSkewedTree() {
        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(2);
        root4.right.right = new TreeNode(3);
        root4.right.right.right = new TreeNode(4);
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> level1 = new ArrayList<>();
        level1.add(1);
        List<Integer> level2 = new ArrayList<>();
        level2.add(2);
        List<Integer> level3 = new ArrayList<>();
        level3.add(3);
        List<Integer> level4 = new ArrayList<>();
        level4.add(4);
        expected.add(level1);
        expected.add(level2);
        expected.add(level3);
        expected.add(level4);
        assertEquals(expected, ZigZagTraversal.zigZagTraversal(root4));
    }

    @Test
    public void testFullBinaryTree() {
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        root5.left.left = new TreeNode(4);
        root5.left.right = new TreeNode(5);
        root5.right.left = new TreeNode(6);
        root5.right.right = new TreeNode(7);
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> level1 = new ArrayList<>();
        level1.add(1);
        List<Integer> level2 = new ArrayList<>();
        level2.add(3);
        level2.add(2);
        List<Integer> level3 = new ArrayList<>();
        level3.add(4);
        level3.add(5);
        level3.add(6);
        level3.add(7);
        expected.add(level1);
        expected.add(level2);
        expected.add(level3);
        assertEquals(expected, ZigZagTraversal.zigZagTraversal(root5));
    }

    @Test
    public void testTreeWithMissingNodes() {
        TreeNode root6 = new TreeNode(1);
        root6.left = new TreeNode(2);
        root6.left.right = new TreeNode(3);
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> level1 = new ArrayList<>();
        level1.add(1);
        List<Integer> level2 = new ArrayList<>();
        level2.add(2);
        List<Integer> level3 = new ArrayList<>();
        level3.add(3);
        expected.add(level1);
        expected.add(level2);
        expected.add(level3);
        assertEquals(expected, ZigZagTraversal.zigZagTraversal(root6));
    }
}
