package code.problem.medium;

import java.util.List;

/**
 * 120. Triangle
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle {
    public int minimumTotal(List <List <Integer>> triangle) {
        if (triangle.size() == 1) {
            triangle.get(0).get(0);
        }
        return helper(triangle);
    }

    public int helper(List <List <Integer>> triangle) {
        int levels = triangle.size();
        int dp[][] = new int[levels][levels];

        //Set the Last row of the triangle as minimum sum
        for (int i = 0; i < triangle.get(levels - 1).size(); i++) {
            dp[levels - 1][i] = triangle.get(levels - 1).get(i);
        }

        //bottom up Dijkstra
        for (int l = levels - 2; l >= 0; l--) {
            for (int i = 0; i <= l; i++) {
                dp[l][i] = Math.min(dp[l + 1][i], dp[l + 1][i + 1]) + triangle.get(l).get(i);
            }
        }
        return dp[0][0];
    }
}
