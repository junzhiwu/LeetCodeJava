// LeetCode 78 SubSets

import java.util.*;
public class SubSet {
	//back tracking recursion [1,2,3], [1,2], [1],
	public List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        helper1(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    private void helper1(int[] nums, int pos, List<Integer> list, List<List<Integer>> result) {
        if (pos == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        list.add(nums[pos]);
        helper1(nums, pos + 1, list, result);
        list.remove(list.size() - 1);
        helper1(nums, pos + 1, list, result);
    }
	
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        result.add(new ArrayList<Integer>());
        helper2(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    private void helper2(int[] nums, int pos, List<Integer> list, List<List<Integer>> result) {
        if (pos == nums.length) return;
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<Integer>(list));
            helper2(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        result.add(new ArrayList<Integer>());
        helper3(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    private void helper3(int[] nums, int pos, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            helper3(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets4(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            for (List<Integer> list: result) {
                List<Integer> nextList = new ArrayList<Integer>(list);
                nextList.add(nums[i]);
                result.add(nextList);
            }
        }
        return result;
    }
    //bit manipulation
    public List<List<Integer>> subsets5(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        int len = nums.length;
        for (int i = 0; i < (1 << len); i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}
