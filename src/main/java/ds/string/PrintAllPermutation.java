package ds.string;


import org.apache.commons.lang3.StringUtils;


public class PrintAllPermutation {

    /**
     * find and print all the possible permutation of a string
     *
     * @param input
     */
    public static void permutation(String input) {
        printStringPermutations("", input);
    }

    /**
     * Private method to take internal parameter permutation
     *
     * @param perm
     * @param word
     */
    private static void printStringPermutations(String perm, String word) {
        if (StringUtils.isEmpty(word)) {
            System.out.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                printStringPermutations(perm + Character.toString(word.charAt(i)), word.substring(0, i) + word.substring(i + 1, word.length()));
            }

        }
    }

    public static void main(String[] args) {
        printStringPermutations("", "1239");
    }
}
