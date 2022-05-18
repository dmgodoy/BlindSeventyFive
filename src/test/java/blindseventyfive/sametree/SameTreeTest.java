package blindseventyfive.sametree;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import static blindseventyfive.sametree.Solution.TreeNode;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SameTreeTest {
    @Test
    public void sameTree() {
        Solution s = new Solution();
        assertTrue(s.isSameTree(Solution.TreeNode.from(1, 2, 3, 4, 5, 6), TreeNode.from(1, 2, 3, 4, 5, 6)));

    }

    @Test
    public void differentTree() {
        Solution s = new Solution();
        assertFalse(s.isSameTree(Solution.TreeNode.from(1, 2, 3, 4, 5), TreeNode.from(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void treeIsNull() {
        assertThrows(NullPointerException.class, SameTreeTest::_leftTreeIsNull);
        assertThrows(NullPointerException.class, SameTreeTest::_rightTreeIsNull);

    }
    static private void _rightTreeIsNull(){
        Solution s = new Solution();
        s.isSameTree(Solution.TreeNode.from(1, 2, 3, 4, 5), null);
    }
    static private void _leftTreeIsNull(){
        Solution s = new Solution();
        s.isSameTree(null, Solution.TreeNode.from(1, 2, 3, 4, 5));
    }

}
