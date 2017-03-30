// LeetCode 47 Permutations II

import java.util.*;

public class Permutation2 {
	public class Solution {
        //backtracking, swap the index of nums array to get different permutation,
        //sort the array and use boolean array to check duplicate
        public List<List<Integer>> permuteUnique1(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (nums == null || nums.length == 0) return result;
            boolean[] used = new boolean[nums.length];
            Arrays.sort(nums);
            helper1(nums, used, new ArrayList<Integer>(), result);
            return result;
        }
        
        public void helper1(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result){
            if(list.size() == nums.length){
                result.add(new ArrayList<Integer>(list));
                return;
            }
            for(int i=0; i<nums.length; i++){
                if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]))
                    continue;
                used[i] = true;
                list.add(nums[i]);
                helper1(nums, used, list, result);
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
        
        public List<List<Integer>> permuteUnique2(int[] nums) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if (nums == null || nums.length == 0) return result;
	        helper2(result, nums, new ArrayList<Integer>(), 0);
	        return result;
	    }
	    private void helper2(List<List<Integer>> result, int[] nums, List<Integer> temp, int pos) {
	        if (pos == nums.length) {
	            result.add(new ArrayList<Integer>(temp));
	            return;
	        }
	        Set<Integer> set = new HashSet<Integer>();
	        for (int i = pos; i < nums.length; i++) {
	            if (set.add(nums[i])) {
	                temp.add(nums[i]);
	                swap(nums, pos, i);
	                helper2(result, nums, temp, pos + 1);
	                swap(nums, i, pos);
	                temp.remove(temp.size() - 1); 
	            }
	        }
	    }
	

        public List<List<Integer>> permuteUnique3(int[] nums) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if(nums == null || nums.length == 0) return res;
	        helper3(res, nums, 0);
	        return res;
	    }
	    private void dfs3(List<List<Integer>> res, int[] nums, int pos){
	        if (pos == nums.length){
	            List<Integer> list = new ArrayList<Integer>();
	            for (int num: nums) list.add(num);
	            res.add(list);
	            return;
	        }
	        Set<Integer> set = new HashSet<Integer>();
	        for(int i = pos; i < nums.length; i++){
	            if (set.add(nums[i])){
	                swap(nums, i, pos);
	                helper3(res, nums, pos + 1);
	                swap(nums, i, pos);
	            }
	        }
	    }
}
