package blindseventyfive.sametree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    static class TreeNode {
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

        static TreeNode from(int ...values) {
            Objects.requireNonNull(values);
            if (values.length == 0)
                throw new IllegalArgumentException("List of values is empty.");
            Map<Integer, TreeNode> mapIdxTreeNode = new HashMap<>();
            for (int i = 0; i < values.length; i++) {
                TreeNode n = mapIdxTreeNode.computeIfAbsent(i, k -> new TreeNode(values[k]));
                final int leftIdx = 2 * i + 1;
                final int rightIdx = 2 * i + 2;
                System.out.println(n);
                n.left = leftIdx < values.length
                        ? mapIdxTreeNode.computeIfAbsent(leftIdx, k -> new TreeNode(values[k])) : null;
                n.right = rightIdx < values.length
                        ? mapIdxTreeNode.computeIfAbsent(rightIdx, k -> new TreeNode(values[k])) : null;

            }
            return mapIdxTreeNode.get(0);
        }
    }

    private boolean _sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && _sameTree(p.left, q.left) && _sameTree(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Objects.requireNonNull(p);
        Objects.requireNonNull(q);
        return _sameTree(p, q);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSameTree(TreeNode.from(1,2,3,4,5), TreeNode.from(1,2,3,4,5,6)));
    }

}
