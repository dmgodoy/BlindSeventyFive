package blindseventyfive.validatebinarysearchtree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private static TreeNode fromInteger(Integer value) {
        if (value == null)
            return null;
        return new TreeNode(value);
    }

    public static TreeNode fromList(List<Integer> list) {
        Objects.requireNonNull(list);
        if (list.isEmpty())
            throw new IllegalArgumentException("The list is empty");
        List<TreeNode> nodes = list.stream().map(TreeNode::fromInteger).collect(Collectors.toList());
        for (int i = 0; i < nodes.size(); i++) {
            if (2 * i + 1 < nodes.size())
                nodes.get(i).left = nodes.get(2 * i + 1);
            if (2 * i + 2 < nodes.size())
                nodes.get(i).right = nodes.get(2 * i + 2);
        }
        return nodes.get(0);
    }

    static void printInOrder(TreeNode n) {
        if (n == null)
            return;
        printInOrder(n.left);
        System.out.println(n.val);
        printInOrder(n.right);
    }

    static void printPreOrder(TreeNode n) {
        if (n == null)
            return;
        System.out.println(n.val);
        printPreOrder(n.left);
        printPreOrder(n.right);

    }

    static void printPostOrder(TreeNode n) {
        if (n == null)
            return;
        printPostOrder(n.left);
        printPostOrder(n.right);
        System.out.println(n.val);

    }

    static void printArray(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            System.out.println(n.val);
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.fromList(Arrays.asList(100, 50, 150, 25, 75, 125, 175, 12, 35, 60, 80, 115, 140, 160, 180));
        TreeNode.printInOrder(root);
        

    }

}