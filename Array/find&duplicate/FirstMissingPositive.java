//LeetCode 41. First Missing Positive

import java.util.*;
public class FirstMissingPositive {
	//brute force O(n^2) time
	public int firstMissingPositive1(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 1; i <= nums.length; i++) {
            boolean found = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }
            if (found == false) return i;
            found = false;
        }
        return nums.length + 1;
    }
	
	//sort and binary search O(nlogn) time
	public int firstMissingPositive2(int[] nums) {
        int max = nums.length + 1;
        Arrays.sort(nums);
        for (int i = 1; i < max; i++) {
            if (Arrays.binarySearch(nums,i) < 0) 
                return i;
        }
        return max;
    }
	
	//rearrange the array and check the non matched number
	public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) 
                swap (nums, i, nums[i] - 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) 
                result.add(nums[i]);
        }
        return result;
    }
    
    private static void swap (int[]nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
