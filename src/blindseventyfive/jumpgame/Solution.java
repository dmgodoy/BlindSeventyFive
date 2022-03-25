package blindseventyfive.jumpgame;

public class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length && i <= reach; ++i){
            reach = Math.max(i + nums[i], reach);
            if(reach >= nums.length - 1)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();        
        System.out.println(s.canJump(new int[]{3,2,1,0,4}));
    }
}
