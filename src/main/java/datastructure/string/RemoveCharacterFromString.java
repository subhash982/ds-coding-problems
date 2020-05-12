package string;

import org.apache.commons.lang3.StringUtils;

public class RemoveCharacterFromString {

    /**
     * Remove a character from a string
     *
     * @param input
     * @param character
     * @return
     */
    public static String removeCharsFromString(String input, Character character) {
        if (StringUtils.isEmpty(input) || character == null) {
            return input;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != character) {
                builder.append(input.charAt(i));
            }
        }
        return builder.toString();

    }

    /**
     * Remove a character from a string using the recursion
     *
     * @param word
     * @param ch
     * @return
     */
    public static String removeRecursive(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        return removeRecursive(word.substring(0, index) + word.substring(index + 1, word.length()), ch);
    }

    public static void main(String[] args) {
        System.out.println(removeCharsFromString("asdbafgaaaa", 'a'));
        System.out.println(removeRecursive("asdbafgaaaa", 'a'));
    }
}
