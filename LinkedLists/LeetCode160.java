package LinkedLists;

import java.rmi.NotBoundException;

import org.xml.sax.helpers.NamespaceSupport;

public class LeetCode160 {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static int intersectionPoint(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != temp2) {
            if (temp1 == null) {
                temp1 = head2;
            } else {
                temp1 = temp1.next;
            }

            if (temp2 == null) {
                temp2 = head1;
            } else {
                temp2 = temp2.next;
            }
        }
        if (temp1 == null) {
            return -1;
        }
        return temp1.data;
    }

    public static void main(String[] args) {
        LeetCode160 ll1 = new LeetCode160();
        ll1.addFirst(5);
        ll1.addFirst(4);
        ll1.addFirst(3);
        ll1.addFirst(2);
        ll1.addFirst(1);

        LeetCode160 ll2 = new LeetCode160();
        ll2.addFirst(8);
        ll2.addFirst(7);
        ll2.addFirst(6);
        ll2.tail.next = ll1.head.next.next;
        ll2.tail = ll1.tail;

        System.out.println(intersectionPoint(ll1.head,ll2.head));
    }
}
