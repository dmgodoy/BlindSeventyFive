package blindseventyfive.searchinrotatedsortedarray;


class Solution {

	public int search(int[] nums, int start, int end, int target){
		int size = end - start;
		if(size == 1)
			return nums[start] == target? start : -1;
		if(nums[start] == target)
			return start;
		if(nums[start] < nums[end - 1] && (target < nums[start] || target > nums[end - 1]))
			return -1;
		int firstHalf = search(nums, start, start + size/2, target);
		int secondHalf = search(nums, start + size/2, end, target);
		return firstHalf == -1? secondHalf : firstHalf;
	}
	public int search(int[] nums, int target) {
        return search(nums, 0, nums.length, target);
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.search(new int[]{1,2,3,4,5,6}, 5));
	}
}