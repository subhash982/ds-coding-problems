package leetcode.medium;

/**
 * 91. Decode Ways
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int [] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1] = s.charAt(0)=='0' ? 0:1;
        for(int i=2 ;i <= s.length();i++){
            int oneDigit = Integer.parseInt(s.substring(i-1,i));
            int twoDigit = Integer.parseInt(s.substring(i-2,i));
            if(oneDigit >=1){
                dp[i]+=dp[i-1];
            }
            if(twoDigit >=10 && twoDigit <=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }



}
