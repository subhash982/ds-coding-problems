package code.problem.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List <List<Integer>> result = new ArrayList <>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        List <Integer> permutation = new ArrayList <>();
        backTracking(result, permutation, nums, used);
        return result;
    }

    public void backTracking(List<List<Integer>> result,List<Integer> permutation,int[] nums,boolean[] used){
        if(permutation.size()== nums.length){
            result.add(new ArrayList <>(permutation));
            return;
        }

        for(int i=0;i < nums.length;i++){
            if(used[i]){
                continue;
            }
            used[i]=true;
            permutation.add(nums[i]);
            backTracking(result,permutation,nums,used);
            permutation.remove(permutation.size()-1);
            used[i]=false;

        }
    }
}
