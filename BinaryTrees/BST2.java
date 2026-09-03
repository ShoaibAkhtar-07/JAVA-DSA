package BinaryTrees;

import Stack.stackB;

public class BST2 {
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

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //Creating a Binary Search Tree using Sorted Array
    public static Node BSTFromSortedArr(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + ((end - start) / 2);
        Node root = new Node(arr[mid]);
        root.left = BSTFromSortedArr(arr, start, mid - 1);
        root.right = BSTFromSortedArr(arr, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = BSTFromSortedArr(arr, 0, arr.length - 1);
        preOrder(root);
    }
}
