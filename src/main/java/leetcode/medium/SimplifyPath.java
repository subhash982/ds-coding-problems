package leetcode.medium;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 71.Simplify Path
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * <p>
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
 * <p>
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 * <p>
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 * <p>
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * Example 4:
 * <p>
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * Example 5:
 * <p>
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * Example 6:
 * <p>
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 */
public class SimplifyPath {
    public static  String simplifyPath(String path) {
        if(path==null || path.trim().length()==0){
            return path;
        }
        Stack<String> stack=new Stack();
        for(String currElemet : path.split("/")){
            if(!stack.empty() && currElemet.equals("..")){
                stack.pop();
            }else if(!currElemet.equals(".") && !currElemet.equals("") && !currElemet.equals("..")){
                stack.push(currElemet);
            }

        }
        return "/"+String.join("/",new ArrayList <>(stack));
    }

    public static void main(String[] args) {
        System.out.print(simplifyPath("/a//b////c/d//././/.."));
    }
}
