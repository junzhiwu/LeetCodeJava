
public class FindTheDuplicateNumber {
	//brute force
	public int findDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) 
                    return nums[i];
            }
        }
        return nums[0];
    }
	//binary search
	 public int findDuplicate2(int[] nums) {
        int l = 1, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1, count = 0;
            for (int num: nums) {
                if (num <= m) count++;
            }
            if (count > m) r = m - 1;
            else l = m + 1;
        }
        return l;
    }
	 //Floyd’s cycle finding algorithm
	 public int findDuplicate3(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (nums[slow] != nums[fast]) {
            if (slow == nums[slow]) return slow;
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            if (slow == nums[slow]) return slow;
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
