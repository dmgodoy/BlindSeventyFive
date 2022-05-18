package blindseventyfive.insertinterval;

import java.util.LinkedList;
import java.util.List;

class Solution2 {
    public static void print(List<int[]> l) {
        l.forEach(e -> {
            System.out.print("[" + e[0] + ", " + e[1] + "] ");
        });
        System.out.println();
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new LinkedList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0])
            resultList.add(intervals[i++]);
        while (i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval = new int[] { Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
            i++;
        }
        resultList.add(newInterval);
        while(i < intervals.length)
            resultList.add(intervals[i++]);
        return resultList.toArray(new int[][] {});
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[][] result = s.insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } },
                new int[] { 4, 8 });
        for (int i = 0; i < result.length; i++)
            System.out.print("[" + result[i][0] + ", " + result[i][1] + "] ");

    }
}