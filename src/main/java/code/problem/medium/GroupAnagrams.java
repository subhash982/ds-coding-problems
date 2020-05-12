package code.problem.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. Group Anagrams
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {

    public static List <List <String>> groupAnagramsMySolution(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        HashMap <String, List <String>> mapIndex = new HashMap <>();
        for (String currString : strs) {
            char[] chArray = currString.toCharArray();
            Arrays.sort(chArray);
            String sortedString = new String(chArray);
            if (mapIndex.get(sortedString) == null) {
                mapIndex.put(sortedString, new ArrayList <>());
            }
            mapIndex.get(sortedString).add(currString);
        }

        return new ArrayList <>(mapIndex.values());
    }

    public static List <List <String>> groupAnagramsOptimal(String[] strs) {
        List <List <String>> result = new ArrayList <List <String>>();

        HashMap <String, ArrayList <String>> map = new HashMap <String, ArrayList <String>>();
        for (String str : strs) {
            char[] arr = new char[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            String ns = new String(arr);
            if (map.containsKey(ns)) {
                map.get(ns).add(str);
            } else {
                ArrayList <String> al = new ArrayList <String>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());

        return result;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagramsMySolution(new String[]{"qwee", "asdbhu", "qewe"}));
    }
}
