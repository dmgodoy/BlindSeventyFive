package blindseventyfive.decodeways;

import java.util.Objects;

class Solution {
    public int numDecodings(String s) {
        Objects.nonNull(s);
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0') // solutions using i - 1 as a single digit
                dp[i] = dp[i - 1];
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) // solutions using combination of i - 2 and i - 1
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("12345"));
    }
}