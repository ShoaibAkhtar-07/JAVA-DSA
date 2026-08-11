package BinaryTrees;

import Stack.stackUsingLinkedList;

public class SubtreesOfAnotherTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree {
        Node root;

    }

    public static boolean isIdentical(Node root, Node subroot) {
        if (root == null && subroot == null) {
            return true;
        } else if (root == null || subroot == null || root.data != subroot.data) {
            return false;
        }

        if (!isIdentical(root.left, subroot.left)) {
            return false;
        }

        if (!isIdentical(root.right, subroot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node subroot) {
        if (root == null) {
            return false;
        }

        if (root.data == subroot.data) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(1);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(5);
        tree.root.right = new Node(1);
        tree.root.right.right = new Node(1);

        BinaryTree subtree = new BinaryTree();
        subtree.root = new Node(1);
        subtree.root.left = new Node(1);
        subtree.root.right = new Node(6);

        System.out.println(isSubtree(tree.root, subtree.root));
    }
}
