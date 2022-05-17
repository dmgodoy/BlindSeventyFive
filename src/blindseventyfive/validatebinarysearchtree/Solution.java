package blindseventyfive.validatebinarysearchtree;

import java.util.Arrays;
import java.util.Objects;
/**
 * We traverse the tree making sure the BST invariant is respected. Time complexity in O(n) and space complexity is O(log(n))
 * @author david
 *
 */
class Solution {

    public boolean isValidBST(TreeNode root) {
        Objects.requireNonNull(root);
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
    public static void main(String[] args) {
        TreeNode root = TreeNode.fromList(Arrays.asList(100, 50, 150, 25, 75, 125, 175, 12, 35, 60, 80, 115, 140, 160, 180));

        Solution s = new Solution();
        System.out.println(s.isValidBST(root));
    }

}