package code.problem.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static List <List <Integer>> threeSum(int[] nums) {
        List <List <Integer>> output_triplet = new LinkedList <>();
        //Sort the array
        Arrays.sort(nums);
        //Run the loop till last 3rd element
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (sum == nums[low] + nums[high]) {
                        output_triplet.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        //Remove the duplicates
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (sum < nums[low] + nums[high]) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }

        }
        return output_triplet;

    }

    public static void main(String[] args) {
        List <List <Integer>> triplets = threeSum(new int[]{1, -1,-1, 0});
        for (List <Integer> triplet : triplets) {
            System.out.println("[" + triplet.get(0) + "," + triplet.get(1) + "," + triplet.get(2) + "]");
        }
    }
}
