

import java.util.*;
public class ContainsDuplicate2 {
    //brute force
    public boolean containsNearbyDuplicate0(int[] nums, int k) {
        if (null == nums || nums.length == 0)
            return false;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //hashMap
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (null == nums || nums.length == 0){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
    
    //HashSet of size k: sliding window
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if(null == nums || nums.length == 0 || k == 0){
            return false;
        }
        Set<Integer> set = new HashSet<Integer>(k);
        for (int i = 0; i < nums.length; i++){
            if (i > k)  set.remove(nums[i - k - 1]);
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
