package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Depth First Search of binary Tree: inorder, preorder, postorder traversals
 * Breadth First Search of binary Tree: level order traversal
 */
public class Traversal {

    /**
     * Time complexity: O(n)
     * space complexity: O(h), h is height of tree
     * @param root - root of tree
     * @return - inorder traversal of of the nodes' values
     */
    public List<Integer> inorder(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        _inorder(root, out);
        return out;
    }

    private void _inorder(TreeNode root, List<Integer> out) {
        if (root == null) {
            return;
        }
        _inorder(root.left, out);
        out.add(root.val);
        _inorder(root.right, out);
    }

    /**
     * Time complexity: O(n)
     * space complexity: O(h), h is height of tree
     * @param root - root of tree
     * @return postorder traversal of of the nodes' values
     */
    public List<Integer> postorder(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        _postorder(root, out);
        return out;
    }

    private void _postorder(TreeNode root, List<Integer> out) {
        if (root == null) { return; }
        _postorder(root.left, out);
        _postorder(root.right, out);
        out.add(root.val);
    }

    /**
     * time complexity: O(n)
     * space complexity: O(h), h is height of tree
     * @param root - root of tree
     * @return preorder traversal of of the nodes' values
     */
    public List<Integer> preorder(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        _preorder(root, out);
        return out;
    }

    private void _preorder(TreeNode root, List<Integer> out) {
        if (root == null) { return; }
        out.add(root.val);
        _preorder(root.left, out);
        _preorder(root.right, out);
    }

    /**
     * time complexity: O(n)
     * space complexity: O(w) where w is max width of binary tree
     * @param root - root of tree
     * @return levelorder traversal of of the nodes' values
     */
    public List<Integer> levelorder(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            if (temp == null) { continue; }
            out.add(temp.val);
            q.add(temp.left);
            q.add(temp.right);
        }
        return out;
    }

    public static void main(String[] args) {

    }
}
