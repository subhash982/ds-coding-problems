package code.problem.easy;

/**
 * 20.Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * Example 1:
 * Input: "()"
 * Output: true
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * Input: "(]"
 * Output: false
 * Example 4:
 * Input: "([)]"
 * Output: false
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        char[] stack = new char[length];
        int i = 0;
        int top = -1;
        while (i < length) {
            char ch = s.charAt(i);
            i++;
            System.out.println(ch);
            if (ch == '(' || ch == '[' || ch == '{') {
                top++;
                stack[top] = ch;

            } else if (ch == ')') {
                if (top != -1 && stack[top] == '(') {
                    top--;
                } else {
                    return false;
                }

            } else if (ch == ']') {
                if (top != -1 && stack[top] == '[') {
                    top--;
                } else {
                    return false;
                }

            } else if (ch == '}') {
                if (top != -1 && stack[top] == '{') {
                    top--;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
}
