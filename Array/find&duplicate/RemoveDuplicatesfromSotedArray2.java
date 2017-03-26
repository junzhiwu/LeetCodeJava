package duplicateCountArray;
import java.util.*;
public class RemoveDuplicatesfromSotedArray2 {
	//use count for each number
	public int removeDuplicates1(int[] nums) { 
		if (nums == null || nums.length <= 2) {
        	return nums == null? 0: nums.length;
        }
        int pre = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[pre]) {
            	if (++count <= 2) {
            		nums[++pre] = nums[i];
            	}
            } else {
            	nums[++pre] = nums[i];
                count = 1;
            }
        }
        return pre + 1;
    }
	
	//use the iterate number and another index to constrain the count
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2)
            return nums == null ? 0 : nums.length;
        int pre = 0;
        for (int num: nums) {
            if (pre < 2 || num > nums[pre - 2])
                nums[pre++] = num;
        }
        return pre;
    }
}
