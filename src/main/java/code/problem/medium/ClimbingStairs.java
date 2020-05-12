package code.problem.medium;

/**
 * 70.Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int [] memo =new int[n+1];
        return climbStairsRecurse(0,n,memo);
    }

    public int climbStairsRecurse(int totalSteps,int tottalStairs,int [] memo) {
        if(totalSteps>tottalStairs){
            return 0;
        }

        if(totalSteps==tottalStairs){
            return 1;
        }
        if(memo[totalSteps] >0){
            return memo[totalSteps];
        }
        memo[totalSteps]= climbStairsRecurse(totalSteps+1,tottalStairs,memo)+climbStairsRecurse(totalSteps+2,tottalStairs,memo);
        return memo[totalSteps];

    }
}
