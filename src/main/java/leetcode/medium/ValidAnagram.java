package leetcode.medium;

import java.util.Arrays;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.

 Example 1:

 Input: s = "anagram", t = "nagaram"
 Output: true
 Example 2:

 Input: s = "rat", t = "car"
 Output: false
 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s==null && t==null){
            return true;
        }

        if(s.length()!=t.length()){
            return false;
        }
        char [] ch = s.toCharArray();
        Arrays.sort(ch);
        s = new String(ch);
        ch = t.toCharArray();
        Arrays.sort(ch);
        t= new String(ch);
        return s.compareTo(t)==0;
    }

    public boolean isAnagramSecondSolution(String s, String t) {
        if(s==null && t==null){
            return true;
        }

        if(s.length()!=t.length()){
            return false;
        }

        char [] ch = new char[26];
        String tempString =new String (ch);

        for(int i=0;i < s.length();i++){
            ch[s.charAt(i)-'a']++;
            ch[t.charAt(i)-'a']--;
        }

        return tempString.compareTo(new String(ch))==0;
    }

}
