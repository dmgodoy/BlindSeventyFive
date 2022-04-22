package blindseventyfive.insertinterval;

import java.util.LinkedList;
import java.util.List;

class Solution {

    boolean overlapping(int[] i1, int[] i2){
        int[] l = i1;
        int[] h = i2;
        if(l[0] >= h[0]){
            l = i2;
            h = i1;
        }
        if(h[0] <= l[1])
            return true;

        return false;
    }
    int[] merge(int[] i1, int[] i2){
        int[] m = new int[2];
        m[0] = Math.min(i1[0], i2[0]);
        m[1] = Math.max(i1[1], i2[1]);
        return m;
    }
    public static void print(List<int[]> l){
        l.forEach(e -> {
            System.out.print("["+e[0]+", "+e[1]+"] ");
        });
        System.out.println();
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new LinkedList<>();
        //list insertion in java is constant
        for (int i = 0; i < intervals.length; i++)
            resultList.add(intervals[i]);

        int idx = 0;
        for(idx = 0; idx < resultList.size(); idx++){
            if(overlapping(newInterval, resultList.get(idx))){
                int[] mergedInterval = merge(newInterval, resultList.get(idx));
                resultList.set(idx, mergedInterval);
                break;
            }
        }
        if(idx == resultList.size())
            return insert(resultList, newInterval).toArray(new int[][]{});
        else{ // from idx keep merging the top of the list
            while((idx + 1) < resultList.size() && overlapping(resultList.get(idx), resultList.get(idx + 1))){
                int[] mergedInterval = merge(resultList.get(idx), resultList.get(idx + 1));
                resultList.remove(idx + 1);
                resultList.set(idx, mergedInterval);
            }
        }
        
        return resultList.toArray(new int[][] {});
    }

    private List<int[]> insert(List<int[]> resultList, int[] newInterval) {
        for (int i = 0; i < resultList.size(); i++) {
            if(newInterval[0] < resultList.get(i)[0]){
                resultList.add(i, newInterval);
                return resultList;
            }
        }
        resultList.add(newInterval);
        return resultList;        
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] result = s.insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }, new int[] { 4, 8 });
        for (int i = 0; i < result.length; i++)
            System.out.print("["+result[i][0]+", "+result[i][1]+"] ");
            
            
        
        
        
        
    }
}