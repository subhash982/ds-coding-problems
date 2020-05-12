package cracking.coding.interview.ch4;


public class CreateMinimalBSTFromSortedArray {

    private static TreeNode createMinimalBST(int[] sortedData) {
        return createMinimalBST(sortedData, 0, sortedData.length - 1);

    }

    private static TreeNode createMinimalBST(int[] sortedData, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return null;
        }

        int mid = (startIndex + endIndex) / 2;
        TreeNode node = new TreeNode(sortedData[mid]);
        node.setLeft(createMinimalBST(sortedData, startIndex, mid - 1));
        node.setRight(createMinimalBST(sortedData, mid + 1, endIndex));
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = createMinimalBST(new int[]{2,4,7,9,12,15,17,19,20});
        System.out.println(node.getData());
    }
}
