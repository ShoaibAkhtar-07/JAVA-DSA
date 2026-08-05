package BinaryTrees;

public class UniValuedBinaryTree {

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

    static boolean helper(Node root, int val) {
        if (root == null) {
            return true;
        }
        if (root.data != val) {
            return false;
        }
        return helper(root.left, val) && helper(root.right, val);
    }

    static boolean isUniValued(Node root) {
        if (root == null) {
            return true;
        }

        return helper(root, root.data);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(1);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(5);
        tree.root.right = new Node(1);
        tree.root.right.right = new Node(1);

        System.out.println(isUniValued(tree.root));
    }
}
