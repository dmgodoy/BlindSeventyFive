package blindseventyfive.uniquepaths;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] pd = new int[m][n];
        for (int j = 0; j < n; j++)
            pd[0][j] = 1;
        for (int i = 0; i < m; i++)
            pd[i][0] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                pd[i][j] = pd[i - 1][j] + pd[i][j - 1];
            
        return pd[m - 1][n - 1];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(3, 7));
    }
}
