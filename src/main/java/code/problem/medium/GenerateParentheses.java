package code.problem.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> paranthesis = new LinkedList <>();
        backtrack(paranthesis,"",0,0,n);
        return paranthesis;

    }
    public void backtrack   ( List<String> paranthesis,String currString,int open,int close,int max) {
        if(currString.length()==max*2){
            paranthesis.add(currString);
        }
        if(open < max)backtrack(paranthesis,currString+"(",open+1,close,max);
        if(close < open)backtrack(paranthesis,currString+")",open,close+1,max);
    }
}
