package TreeTest;

import Tree.Traversal;
import Tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TraversalTest {
    Traversal myTraversal = new Traversal();

    @Test
    public void basicTest() {
        TreeNode basicLeftSubtree = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode basicRoot = new TreeNode(1, basicLeftSubtree, new TreeNode(3));
        TreeNode largeLeftSubtree = new TreeNode(2, new TreeNode(4, null, new TreeNode(7)), null);
        TreeNode largeRightSubtree = new TreeNode(3, new TreeNode(5), new TreeNode(6, new TreeNode(8, new TreeNode(10, new TreeNode(11), null), null), new TreeNode(9)));
        TreeNode largeRoot = new TreeNode(1, largeLeftSubtree, largeRightSubtree);

        List<Integer> inorderBasicTraversal = Arrays.asList(4, 2, 5, 1, 3);
        List<Integer> preorderBasicTraversal = Arrays.asList(1, 2, 4, 5, 3);
        List<Integer> postorderBasicTraversal = Arrays.asList(4, 5, 2, 3, 1);
        List<Integer> levelorderBasicTraversal = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> inorderLargeTraversal = Arrays.asList(4, 7, 2, 1, 5, 3, 11, 10, 8, 6, 9);
        List<Integer> preorderLargeTraversal = Arrays.asList(1, 2, 4, 7, 3, 5, 6, 8, 10, 11, 9);
        List<Integer> postorderLargeTraversal = Arrays.asList(7, 4, 2, 5, 11, 10, 8, 9, 6, 3, 1);
        List<Integer> levelorderLargeTraversal = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

        Assert.assertEquals(inorderBasicTraversal, myTraversal.inorder(basicRoot));
        Assert.assertEquals(preorderBasicTraversal, myTraversal.preorder(basicRoot));
        Assert.assertEquals(postorderBasicTraversal, myTraversal.postorder(basicRoot));
        Assert.assertEquals(levelorderBasicTraversal, myTraversal.levelorder(basicRoot));
        Assert.assertEquals(inorderLargeTraversal, myTraversal.inorder(largeRoot));
        Assert.assertEquals(preorderLargeTraversal, myTraversal.preorder(largeRoot));
        Assert.assertEquals(postorderLargeTraversal, myTraversal.postorder(largeRoot));
        Assert.assertEquals(levelorderLargeTraversal, myTraversal.levelorder(largeRoot));
    }

    @Test
    public void emptyTree() {
        TreeNode root = new TreeNode(1);
        TreeNode empty = null;

        List<Integer> expectedRoot = Collections.singletonList(1);
        List<Integer> expectedEmpty = new ArrayList<>();

        Assert.assertEquals(expectedRoot, myTraversal.inorder(root));
        Assert.assertEquals(expectedRoot, myTraversal.preorder(root));
        Assert.assertEquals(expectedRoot, myTraversal.postorder(root));
        Assert.assertEquals(expectedRoot, myTraversal.levelorder(root));
        Assert.assertEquals(expectedEmpty, myTraversal.inorder(empty));
        Assert.assertEquals(expectedEmpty, myTraversal.preorder(empty));
        Assert.assertEquals(expectedEmpty, myTraversal.postorder(empty));
        Assert.assertEquals(expectedEmpty, myTraversal.levelorder(empty));
    }

    @Test
    public void linkedListTree() {
        TreeNode leftLinkedList = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), null);
        TreeNode rightLinkedList = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

        List<Integer> inorderLeft = Arrays.asList(4, 3, 2, 1);
        List<Integer> preorderLeft = Arrays.asList(1, 2, 3, 4);
        List<Integer> postorderLeft = Arrays.asList(4, 3, 2, 1);
        List<Integer> levelorderLeft = Arrays.asList(1, 2, 3, 4);

        List<Integer> inorderRight = Arrays.asList(1, 2, 3, 4);
        List<Integer> preorderRight = Arrays.asList(1, 2, 3, 4);
        List<Integer> postorderRight = Arrays.asList(4, 3, 2, 1);
        List<Integer> levelorderRight = Arrays.asList(1, 2, 3, 4);

        Assert.assertEquals(inorderLeft, myTraversal.inorder(leftLinkedList));
        Assert.assertEquals(preorderLeft, myTraversal.preorder(leftLinkedList));
        Assert.assertEquals(postorderLeft, myTraversal.postorder(leftLinkedList));
        Assert.assertEquals(levelorderLeft, myTraversal.levelorder(leftLinkedList));
        Assert.assertEquals(inorderRight, myTraversal.inorder(rightLinkedList));
        Assert.assertEquals(preorderRight, myTraversal.preorder(rightLinkedList));
        Assert.assertEquals(postorderRight, myTraversal.postorder(rightLinkedList));
        Assert.assertEquals(levelorderRight, myTraversal.levelorder(rightLinkedList));
    }


}
