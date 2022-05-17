package blindseventyfive.validatebinarysearchtree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
/**
 * The in order traversal of a binary search tree is the nodes in ascending order. This implementation is simpler but the space complexity is linear.
 * 
 * @author david
 *
 */
class Solution2 {

    public boolean isValidBST(TreeNode root) {
        Objects.requireNonNull(root);
        List<Integer> inOrderList = new LinkedList<>();
        inOrder(root, inOrderList);
        for (int i = 1; i < inOrderList.size(); i++) {
            if(inOrderList.get(i - 1) >= inOrderList.get(i))
                return false;
        }
        return true;
    }
    private void inOrder(TreeNode node, List<Integer> dst){
        if(node == null)
            return;
        inOrder(node.left, dst);
        dst.add(node.val);
        inOrder(node.right, dst);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.fromList(Arrays.asList(100, 50, 150, 25, 75, 116, 175, 12, 35, 60, 80, 115, 140, 160, 180));

        Solution2 s = new Solution2();
        System.out.println(s.isValidBST(root));
    }

}