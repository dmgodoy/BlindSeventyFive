package blindseventyfive.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastAdded = result.get(result.size() - 1); 
            if(lastAdded[1] >= intervals[i][0])
                lastAdded[1] = Math.max(lastAdded[1], intervals[i][1]);
            else
                result.add(intervals[i]);
        }
        return result.toArray(new int[][]{});
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] m = s.merge(new int[][]{{1,4},{4,5}});
        for (int i = 0; i < m.length; i++)
            System.out.print("["+m[i][0]+", "+m[i][1]+"] ");
        
        System.out.println();
    }

}
