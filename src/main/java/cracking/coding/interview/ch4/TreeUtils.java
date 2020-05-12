package cracking.coding.interview.ch4;


import java.util.Arrays;

public class TreeUtils {

    public static TreeNode buildMinimalBinarySearchTree(int[] inputData) {
        Arrays.sort(inputData);
        return createMinimalBinarySearchTree(inputData, 0, inputData.length - 1);

    }


    private static TreeNode createMinimalBinarySearchTree(int[] sortedData, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return null;
        }

        int mid = (startIndex + endIndex) / 2;
        TreeNode node = new TreeNode(sortedData[mid]);
        System.out.println("mid " + mid);

        node.setLeft(createMinimalBinarySearchTree(sortedData, startIndex, mid - 1));
        node.getLeft().setParent(node);
        node.setRight(createMinimalBinarySearchTree(sortedData, mid + 1, endIndex));
        node.getRight().setParent(node);
        return node;
    }

    public static TreeNode buildBinarySearchTree(int[] inputData) {
        TreeNode rootNode = new TreeNode(inputData[0]);
        rootNode.setParent(null);
        for (int i = 1; i < inputData.length; i++) {
            TreeNode currNode = rootNode;
            while (true) {
                if (currNode.getData() >= inputData[i]) {
                    if (currNode.getLeft() == null) {
                        currNode.setLeft(new TreeNode(inputData[i]));
                        currNode.getLeft().setParent(currNode);
                        break;
                    } else {
                        currNode = currNode.getLeft();
                    }

                } else {
                    if (currNode.getRight() == null) {
                        currNode.setRight(new TreeNode(inputData[i]));
                        currNode.getRight().setParent(currNode);
                        break;
                    } else {
                        currNode = currNode.getRight();
                    }
                }

            }
        }
        return rootNode;
    }

}

