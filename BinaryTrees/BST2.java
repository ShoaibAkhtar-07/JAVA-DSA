package BinaryTrees;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

    // // Creating a Binary Search Tree using Sorted Array
    // public static Node BSTFromSortedArr(int[] arr, int start, int end) {
    // if (start > end) {
    // return null;
    // }
    // int mid = start + ((end - start) / 2);
    // Node root = new Node(arr[mid]);
    // root.left = BSTFromSortedArr(arr, start, mid - 1);
    // root.right = BSTFromSortedArr(arr, mid + 1, end);
    // return root;
    // }

    // Sorted Array to Balanced BST
    public static void getInOrder(Node root, ArrayList<Integer> inOrd) {
        if (root == null) {
            return;
        }
        getInOrder(root.left, inOrd);
        inOrd.add(root.data);
        getInOrder(root.right, inOrd);
    }

    public static Node inorderToBST(ArrayList<Integer> arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = inorderToBST(arr, start, mid - 1);
        root.right = inorderToBST(arr, mid + 1, end);
        return root;
    }

    public static Node balanceBST(Node root) {
        // Inorder Sequence
        ArrayList<Integer> inOrd = new ArrayList<>();
        getInOrder(root, inOrd);

        // Sorting inorder -> BST
        return inorderToBST(inOrd, 0, inOrd.size() - 1);

    }

    public static void main(String[] args) {
        // int[] arr = { 3, 5, 6, 8, 10, 11, 12 };
        // Node root = BSTFromSortedArr(arr, 0, arr.length - 1);
        // preOrder(root);

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = balanceBST(root);
        preOrder(root);

    }
}
