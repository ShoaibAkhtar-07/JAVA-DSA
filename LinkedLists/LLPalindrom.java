package LinkedLists;

public class LLPalindrom {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addFirst(int data) {
        // Create a new node
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // linking
        newNode.next = head;

        // assigning head
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Finding mid Node
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // public Node reverseSecondHalf(Node slow) {
    // Node prev = null;
    // Node curr = slow;
    // Node next;

    // while (curr != null) {
    // next = curr.next;
    // curr.next = prev;
    // prev = curr;
    // curr = next;
    // }
    // Node head2 = prev;
    // return head2;
    // }

    // public boolean isPalindrom(Node head, Node head2) {
    // if (head == null || head.next == null) {
    // return true;
    // }

    // while (head2 != null) {
    // if (head.data != head2.data) {
    // return false;
    // }
    // head = head.next;
    // head2 = head2.next;
    // }
    // return true;
    // }


    //Checking is palindrom or Not
    public boolean isPalindrom() {
        if (head == null || head.next == null) {
            return true;
        }

        // assigning Mid Node
        Node midNode = findMid(head);

        // Reversing second Half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        // comparing both halfs
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }

    public static void main(String[] args) {
        LLPalindrom ll = new LLPalindrom();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(1);
        ll.addLast(1);
        ll.addLast(1);
        ll.print();
        System.out.println(ll.isPalindrom());

    }
}
