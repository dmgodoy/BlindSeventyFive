package blindseventyfive.sametree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private static class TreeNode {
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

        static TreeNode fromList(List<Integer> values) {
            Objects.requireNonNull(values);
            if (values.isEmpty())
                throw new IllegalArgumentException("List of values is empty.");
            if (values.size() % 2 == 0)
                throw new IllegalArgumentException(
                        "Number of values" + values.size() + "must be odd. Add null to fill empty values.");
            Map<Integer, TreeNode> mapIdxTreeNode = new HashMap<>();
            for (int i = 0; i < values.size(); i++) {
                TreeNode n = mapIdxTreeNode.getOrDefault(i, new TreeNode(values.get(i)));
                final int leftIdx = 2 * i + 1;
                final int rightIdx = 2 * i + 2;
                n.left = leftIdx < values.size()
                        ? mapIdxTreeNode.getOrDefault(leftIdx, new TreeNode(values.get(leftIdx))) : null;
                n.right = rightIdx < values.size()
                        ? mapIdxTreeNode.getOrDefault(rightIdx, new TreeNode(values.get(rightIdx))) : null;

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
        //System.out.println(s.isSameTree(TreeNode.fromList(null), TreeNode.fromList(null)));
        System.out.println(s.isSameTree(TreeNode.fromList(Arrays.asList(1,2,3,4,5)), TreeNode.fromList(Arrays.asList(1,2,3,4,5))));
    }

}
