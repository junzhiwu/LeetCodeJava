// LeetCode 46 Permutations

import java.util.*;
public class Permutaiton1 {
	// for each element to add, we try all possible locations
	public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        result.add(new ArrayList<Integer>());
        
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> nextLayer = new ArrayList<>();
            for (List<Integer> list: result) {
                for (int j = 0; j <= list.size(); j++) {
                    List<Integer> nextList = new ArrayList<Integer>(list);
                    nextList.add(j, nums[i]);
                    nextLayer.add(nextList);
                }
            }
            result = nextLayer;
        }
        return result;
    }
	
	// for each position, we add a new element(check duplicate)
	public List<List<Integer>> permute2(int[] nums) {
        if (nums == null || nums.length == 0) 
            return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, temp, result);
        return result;
    }
    private void helper(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int num: nums) {
            if (!list.contains(num)) {
                list.add(num);
                helper(nums, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    
    // for each position, we add a new element(check duplicate using boolean array as flag)
    public List<List<Integer>> permute31(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        helper31(nums, used, list, result);
        return result;
    }
    
    public void helper31(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result){
        if(list.size() == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if (used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            helper31(nums,used,list,result);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
    // for each position, we add a new element without checking duplicate by swapping input
    public List<List<Integer>> permute32(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer>list = new ArrayList<Integer>();
        helper(nums, list, result, 0);
        return result;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void helper32(int nums[], List<Integer> list, List<List<Integer>> result, int pos){
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            swap(nums, i, pos);
            helper(nums, list, result, pos + 1);
            swap(nums, i, pos);
            list.remove(list.size() - 1);
        }
    }
    // same as above method, just not use a temp list
    public List<List<Integer>> permute4(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer>list = new ArrayList<Integer>();
        helper(nums, result, 0);
        return result;
    }
    
    public void helper4(int nums[], List<List<Integer>> result, int pos){
        if (pos == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num: nums) list.add(num);
            result.add(list);
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            swap(nums, i, pos);
            helper(nums, result, pos + 1);
            swap(nums, i, pos);
        }
    }
}
