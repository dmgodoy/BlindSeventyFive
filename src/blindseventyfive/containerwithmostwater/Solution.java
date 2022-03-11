package blindseventyfive.containerwithmostwater;

public class Solution {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int containerStart = 0;
        int containerEnd = height.length - 1;
        while(containerStart <= containerEnd){
            int minHeight = Math.min(height[containerStart], height[containerEnd]);
            maxArea = Math.max(maxArea, minHeight * (containerEnd - containerStart));
            if(height[containerStart] < height[containerEnd])
                containerStart++;
            else containerEnd--;
        }
        return maxArea;
    }
	
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
	}
}
