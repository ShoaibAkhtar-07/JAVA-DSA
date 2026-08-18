package BinaryTrees;

import java.sql.Time;
import java.util.*;

import javax.sound.sampled.spi.FormatConversionProvider;

public class BasicsOfBinaryTrees {

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
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }

            }
        }

        public static int heightOfTree(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = heightOfTree(root.left);
            int rh = heightOfTree(root.right);
            int max = (Math.max(lh, rh) + 1);

            return max;
        }

        public static int countOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int LC = countOfNodes(root.left);
            int RC = countOfNodes(root.right);

            return LC + RC + 1;
        }

        public static int sumOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int LSum = sumOfNodes(root.left);
            int RSum = sumOfNodes(root.right);

            return LSum + RSum + root.data;
        }

        // Approach 1 : Time Complexity O(n2);
        // public static int diameterOfTree(Node root) {
        // if (root == null) {
        // return 0;
        // }
        // int leftDia = diameterOfTree(root.left);
        // int lh = heightOfTree(root.left);
        // int rightDia = diameterOfTree(root.right);
        // int rh = heightOfTree(root.right);

        // int selfDia = lh + rh + 1;

        // return Math.max(selfDia, Math.max(leftDia, rightDia));
        // }

        // Approach 2 : Time Complexity O(n)
        static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        public static Info diameter(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }
            Info leftInfo = diameter(root.left);
            Info rightInfo = diameter(root.right);

            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            return new Info(diam, ht);
        }

        static class topInfo {
            Node node;
            int hd;

            topInfo(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        public static void topView(Node root) {
            Queue<topInfo> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();

            int min = 0, max = 0;
            q.add(new topInfo(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                topInfo curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.node);
                    }

                    if (curr.node.left != null) {
                        q.add(new topInfo(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }

                    if (curr.node.right != null) {
                        q.add(new topInfo(curr.node.right, curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }

            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
        }

        // Finding Kth Level of a Tree
        public static void kthLevel(Node root, int level, int k) {
            if (root == null) {
                return;
            }
            if (k == level) {
                System.out.print(root.data + " ");
                return;
            }
            kthLevel(root.left, level + 1, k);
            kthLevel(root.right, level + 1, k);

        }

        // // Finding Lowest common ancestor among 2 nodes

        // public static boolean getpath(Node root, int n, ArrayList<Node> path) {
        // if (root == null) {
        // return false;
        // }
        // path.add(root);
        // if (root.data == n) {
        // return true;
        // }
        // boolean foundLeft = getpath(root.left, n, path);
        // boolean foundright = getpath(root.right, n, path);

        // if ((foundright || foundLeft)) {
        // return true;
        // }

        // path.remove(path.size() - 1);
        // return false;
        // }

        // public static Node lowesrCommonAncestor(Node root, int n1, int n2) {
        // ArrayList<Node> path1 = new ArrayList<>();
        // ArrayList<Node> path2 = new ArrayList<>();

        // getpath(root, n1, path1);
        // getpath(root, n2, path2);

        // int i = 0;
        // for (; i < path1.size() && i < path2.size(); i++) {
        // if (path1.get(i) != path2.get(i)) {
        // break;
        // }
        // }

        // Node lca = path1.get(i - 1);
        // return lca;
        // }

        // Finding Lowest common ancestor among 2 nodes with better Space Complexity

        public static Node lca(Node root, int n1, int n2) {
            if (root == null || root.data == n1 || root.data == n2) {
                return root;
            }

            Node leftLca = lca(root.left, n1, n2);
            Node rightLca = lca(root.right, n1, n2);

            if (leftLca == null) {
                return rightLca;
            }
            if (rightLca == null) {
                return leftLca;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root Node : " + root.data);
        System.out.println("--------------");
        System.out.print("PRE order : ");
        tree.preOrder(root);
        System.out.println();
        System.out.println("--------------");
        System.out.print("IN order : ");
        tree.inOrder(root);
        System.out.println();
        System.out.println("--------------");
        System.out.print("POST order : ");
        tree.postOrder(root);
        System.out.println();
        System.out.println("--------------");
        System.out.println("LEVEL order : ");
        tree.levelOrder(root);
        System.out.println("--------------");
        System.out.print("Height of Tree : ");
        System.out.print(tree.heightOfTree(root));
        System.out.println();
        System.out.println("--------------");
        System.out.print("Count of Total Nodes : ");
        System.out.println(tree.countOfNodes(root));
        System.out.println("--------------");
        System.out.print("Sum of Total Nodes : ");
        System.out.println(tree.sumOfNodes(root));
        System.out.println("--------------");
        System.out.println("Diameter of Tree : " + tree.diameter(root).diam);
        System.out.println("--------------");
        System.out.print("Top View of a Tree : ");
        tree.topView(root);
        System.out.println();
        System.out.println("--------------");
        System.out.print("Kth Level of a Tree :");
        tree.kthLevel(root, 1, 3);
        System.out.println();
        System.out.println("--------------");
        System.out.print("Lowest Common Ancestor : " + tree.lca(root, 4, 5).data);

    }
}