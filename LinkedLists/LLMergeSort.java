package LinkedLists;

public class LLMergeSort {

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

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }

        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Finding mid
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node midNode = slow;

        Node rightHead = midNode.next;
        midNode.next = null;
        Node leftNode = mergeSort(head);
        Node rightNode = mergeSort(rightHead);

        return merge(leftNode, rightNode);
    }

    //zigzag linked linked list
    public void zigzag() {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node miNode = slow;

        Node right = miNode.next;
        miNode.next = null;

        // Reversing second half
        Node prev = null;
        Node curr = right;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        right = prev;
        Node nextL, nextR;
        Node left = head;

        // Alternate Merge
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }

    public static void main(String[] args) {
        LLMergeSort ll = new LLMergeSort();
        // ll.addFirst(5);
        // ll.addFirst(4);
        // ll.addLast(1);
        // ll.addFirst(3);
        // ll.addFirst(8);
        // ll.addFirst(6);
        // ll.addFirst(1);
        // ll.print();
        // ll.mergeSort(head);
        // ll.print();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.zigzag();
        ll.print();

    }
}