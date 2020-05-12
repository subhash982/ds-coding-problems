package tree;

public class BST {
    TreeNode root = null;

    BST(int rootNodeValue) {
        root = new TreeNode(rootNodeValue);
    }

    public void insertNode(int nodeValue) {
        TreeNode node = root;
        while (true) {
            if (node.data >= nodeValue) {
                if (node.left == null) {
                    node.left = new TreeNode(nodeValue);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                if (node.rigth == null) {
                    node.rigth = new TreeNode(nodeValue);
                    break;
                } else {
                    node = node.rigth;
                }
            }
        }
    }

    public void deleteNode(int nodeValue) {
        //TODO need to be implemented
        System.out.print(findNodeTobeDeleted(nodeValue));
    }

    private TreeNode findNodeTobeDeleted(int nodeValue) {
        TreeNode node = root;
        while (node != null) {
            if (node.data > nodeValue) {
                node = node.left;
            } else if (node.data < nodeValue) {
                node = node.rigth;
            } else {
                return node;
            }
        }
        return node;

    }


    public void printInorderTreeTraversal() {
        System.out.println("Printing the inorder traversal");
        printInorderTreeTraversalRecurse(root);
    }

    public void printInorderTreeTraversalRecurse(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorderTreeTraversalRecurse(root.left);
        System.out.print(root.data + " ");
        printInorderTreeTraversalRecurse(root.rigth);
    }

    public static void main(String[] args) {
        BST binarySearcgTree = new BST(10);
        binarySearcgTree.insertNode(20);
        binarySearcgTree.insertNode(12);
        binarySearcgTree.insertNode(43);
        binarySearcgTree.insertNode(12);
        binarySearcgTree.insertNode(7);
        binarySearcgTree.insertNode(4);

        binarySearcgTree.printInorderTreeTraversal();

        System.out.println(" ");
        binarySearcgTree.deleteNode(7);

        binarySearcgTree.deleteNode(123);
    }

    private class TreeNode {
        TreeNode left = null;
        TreeNode rigth = null;
        int data;

        TreeNode(int data) {
            this.data = data;
        }

        public String toString() {
            return this.data + " ";
        }
    }
}
