package ds.string;

import java.util.HashMap;

public class FindFirstMatchingCharacter {

    public static Character returnFirstMatchingChar(String input) {
        HashMap <Character, Integer> cache = new HashMap <>();
        for (char ch : input.toCharArray()) {
            if (cache.get(ch) != null && cache.get(ch) > 0) {
                return ch;
            } else {
                cache.put(ch, cache.get(ch) == null ? 1 : cache.get(ch) + 1);
            }
        }
        return 'a';
    }

    public static void main(String[] args) {
        System.out.println(returnFirstMatchingChar("ABCDFAG"));
    }
}
