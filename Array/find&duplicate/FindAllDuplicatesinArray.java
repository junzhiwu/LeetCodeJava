import java.util.*;
public class FindAllDuplicatesinArray {
	//negative operation then get absolute value
	public List<Integer> findDuplicates(int[] nums) {
	    List<Integer> result = new ArrayList<Integer>();
	    for (int num: nums) {
	        int index = Math.abs(num) - 1;
	        if (nums[index] < 0) 
	            result.add(index + 1);
	        else {
	            nums[index] = -nums[index];
	        }
	    }
	    return result;
	}
    //use bit manipulation to do negative operation
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int num: nums) {
            int index = (num & 0x7fffffff) - 1;
            if (nums[index] < 0)
                result.add(index + 1);
            else {
                nums[index] |= 0x80000000;
            }
        }
        return result;
    }
    
	// add size then mod
	public List<Integer> findDuplicates2(int[] nums) {
	    List<Integer> result = new ArrayList<Integer>();
	    for (int num: nums) {
	        int index = (num - 1) % nums.length;
	        if (nums[index] > nums.length) 
	            result.add(index + 1);
	        else {
	            nums[index] += nums.length;
	        }
	    }
	    return result;
	}
	
	//rearrange the array to make nums[i] = i + 1
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
    private void swap (int[] nums, int i, int j) {
        int temp =  nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }