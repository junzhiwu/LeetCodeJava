//LeetCode 254 Factor Combinations

import java.util.*;
public class FactorCombinations {
    //factor from 2 to n
	public List<List<Integer>> getFactors1(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 3) return result;
        helper1(n, 2, new ArrayList<Integer>(), result);
        return result;
    }
    private void helper1(int n, int startFactor, List<Integer> list, List<List<Integer>> result) {
        if (n == 1) {
            if (list.size() > 1) result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = startFactor; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                helper1(n / i, i, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    
    //factor from 2 to sqrt(n) with pruned basescase added back
    public List<List<Integer>> getFactors2(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 3) return result;
        helper2(n, 2, new ArrayList<Integer>(), result);
        return result;
    }
    private void helper2(int n, int startFactor, List<Integer> list, List<List<Integer>> result) {
        if (n == 1) {
            if (list.size() > 1) result.add(new ArrayList<Integer>(list));
            return;
        }
        int upper = (int) Math.sqrt(n);
        for (int i = startFactor; i <= upper; i++) {
            if (n % i == 0) {
                list.add(i);
                helper2(n / i, i, list, result);
                list.remove(list.size() - 1);
            }
        }
        list.add(n);
        helper2(1, n, list, result);
        list.remove(list.size() - 1);
    }
    
    //
    public List<List<Integer>> getFactors3(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 3) return result;
        helper3(n, -1, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void helper3(int n, int startFactor, List<Integer> list, List<List<Integer>> result) {
        if (startFactor != -1) {
            list.add(n);
            result.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
        }
        int upper = (int) Math.sqrt(n);
        for (int i = Math.max(2, startFactor); i <= upper; ++i) {
            if (n % i == 0) {
                list.add(i);
                helper3(n / i, i, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
