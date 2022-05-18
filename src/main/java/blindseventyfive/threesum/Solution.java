package blindseventyfive.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> triplets = new ArrayList<>();
    	for (int i = 0; i < nums.length - 2; i++) {
    		if(i > 0 && nums[i] == nums[i - 1])
    			continue;
    		int j = i + 1;
    		int k = nums.length - 1;
    		while(j < k){
    			int sum = nums[i] + nums[j] + nums[k];
    			if(sum == 0)
    				triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
    			else if(sum > 0){
    				k--;
    				while(nums[k] == nums[k + 1] && k > j)
    					k--;
    			} 
    			if(sum <= 0){
    				j++;
    				while(nums[j] == nums[j - 1] && j < k)
    					j++;
    			}	
    		}
		}
    	
		return triplets;
    }
    public static void main(String[] args) {
		Solution s = new Solution();
		for(List<Integer> l : s.threeSum(new int[]{-1,0,1,2,-1,-4})){
			l.forEach(System.out::println);
			System.out.println();
		}
		
	}
}
