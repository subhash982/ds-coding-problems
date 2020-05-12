package ds.dp;

public class LongestIncreasingSubsequence {
    public static int findLongestIncreasingSequence(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    temp[i] = 1 + temp[j];
                }
            }
        }

        int maxCount = 0;
        for (int count : temp) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

    public static int findLongestIncreasingSequenceRecursive(int[] arr) {
        int maxLength = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int length = findLISUsingRecursion(arr, i + 1, arr[i]);
            if (maxLength < length) {
                maxLength = length;
            }
        }

        return maxLength + 1;
    }

    private static int findLISUsingRecursion(int[] arr, int pos, int lastNum) {
        if (pos == arr.length) {
            return 0;
        }
        int t1 = 0;
        if (arr[pos] > lastNum) {
            t1 = 1 + findLISUsingRecursion(arr, pos + 1, arr[pos]);
        }
        int t2 = findLISUsingRecursion(arr, pos + 1, lastNum);
        return Math.max(t1, t2);
    }

    public static void main(String[] args) {
        System.out.println(findLongestIncreasingSequence(new int[]{50, 3, 10, 7, 40, 80}));
        System.out.println(findLongestIncreasingSequence(new int[]{50, 3, 10, 20, 40, 80}));

        System.out.println(findLongestIncreasingSequenceRecursive(new int[]{50, 3, 10, 7, 40, 80}));
        System.out.println(findLongestIncreasingSequenceRecursive(new int[]{50, 3, 10, 20, 40, 80}));
    }
}
