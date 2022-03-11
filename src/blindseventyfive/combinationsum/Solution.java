package blindseventyfive.combinationsum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> combinations = new ArrayList<>();
		List<Integer> currentSolution = new ArrayList<>();
		combinations(candidates, target, currentSolution, combinations);
		combinations.forEach(e -> Collections.sort(e));
		Set<List<Integer>> set = new HashSet<>(combinations);
        return new ArrayList<>(set);
    }
	    
    public void combinations(int[] candidates, int target, List<Integer> currentSolution, List<List<Integer>>combinations){	

    	for (int i = 0; i < candidates.length; i++) {
    		if(candidates[i] < target){
    			currentSolution.add(candidates[i]);
    			combinations(candidates, target - candidates[i], currentSolution, combinations);
    			currentSolution.remove(currentSolution.size() - 1); //backtrack
    		}
    		if(candidates[i] == target){
    			currentSolution.add(candidates[i]);
    			List<Integer> dest = new ArrayList<>();
    			currentSolution.forEach(e -> dest.add(e));
    			combinations.add(dest);
    			currentSolution.remove(currentSolution.size() - 1);
    		}			
		}
    	
    }
    public static void main(String[] args) {
		Solution s = new Solution();
		for(List<Integer> l : s.combinationSum(new int[]{2,3,6,7}, 7)){
			l.forEach(System.out::println);
			System.out.println();
		}
	}
}
