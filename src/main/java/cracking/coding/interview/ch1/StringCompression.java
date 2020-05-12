package cracking.coding.interview.ch1;

public class StringCompression {

    private static String compress(String str) {
        int compressCount = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            compressCount++;
            if (i + 1 == str.length() || str.charAt(i) != str.charAt(i + 1)) {
                builder.append(str.charAt(i));
                builder.append(compressCount);
                compressCount = 0;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aabbfffnnff"));
    }
}
