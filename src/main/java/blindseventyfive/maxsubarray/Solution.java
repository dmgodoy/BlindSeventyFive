package blindseventyfive.maxsubarray;

class Solution {
    public int maxSubArray(int[] nums) {

    	int[] pd = new int[nums.length];
    	pd[0] = nums[0];
    	int max = pd[0];
    	for (int i = 1; i < pd.length; i++){
			pd[i] = pd[i - 1] < 0? nums[i] : nums[i] + pd[i - 1];
			max = Math.max(max, pd[i]);
    	}
		return max;
    }
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.maxSubArray(new int[]{-2,-1}));
		
	}
}
