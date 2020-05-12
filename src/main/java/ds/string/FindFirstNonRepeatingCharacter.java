package ds.string;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class FindFirstNonRepeatingCharacter {

    /**
     * @param input
     * @return
     */
    public static Character findFirstNonRepeatingChar(String input, boolean ignoreCase) {
        if (StringUtils.isEmpty(input)) {
            return null;
        }

        if (ignoreCase)
            input = input.toLowerCase();
        Map <Character, Integer> counts = new LinkedHashMap <>(input.length());

        for (char c : input.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }

        for (Map.Entry <Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }

    /**
     * find first non repeating charcter using single iteration
     *
     * @param input
     * @return
     */
    public static Character findFirstNonRepeatingCharInSinglePass(String input, boolean ignoreCase) {

        if (StringUtils.isEmpty(input)) {
            return null;
        }
        if (ignoreCase)
            input = input.toLowerCase();

        Set <Character> repChars = new HashSet <>();
        List <Character> nonRepChars = new ArrayList <>();

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (repChars.contains(letter)) {
                continue;
            }
            if (nonRepChars.contains(letter)) {
                nonRepChars.remove((Character) letter);
                repChars.add(letter);
            } else {
                nonRepChars.add(letter);
            }
        }
        return nonRepChars.get(0);
    }


    public static void main(String[] args) {
        System.out.println(findFirstNonRepeatingChar("subhash" ,true));
        System.out.println(findFirstNonRepeatingCharInSinglePass("Subhash",false));
    }
}
