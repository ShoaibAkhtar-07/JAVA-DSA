package LinkedLists;

public class LinkedList {

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
    public static int size;

    public void addFirst(int data) {
        // Create a new node
        Node newNode = new Node(data);
        size++;
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
        size++;
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

    public void addAtInd(int idx, int data) {

        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            size = 0;
            head = tail = null;
            return val;
        }

        int i = 0;
        Node prev = head;
        while (i < size - 2) {
            prev = prev.next;
            i++;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int search(int key) {
        Node temp = head;
        int i = 1;
        while (temp != null) {
            if (key == temp.data) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int recurSearch(int key, Node head) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 1;
        }
        int idx = recurSearch(key, head.next);

        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public void reverseLL() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public int deleteNthFromEnd(int n) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (sz == n) {
            int val = head.data;
            head = head.next;
            return val;
        }

        int i = 1;
        int toFind = sz - n;
        Node prev = head;
        while (i < toFind) {
            prev = prev.next;
            i++;
        }

        Node delNode = prev.next;
        if (delNode == tail) {
            tail = prev;
        }
        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean exists = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                exists = true;
                break;
            }
        }

        if (exists == false) {
            return;
        }
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev == null) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        } else {
            prev.next = null;

        }

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(5);
        ll.addAtInd(3, 3);
        ll.print();
        System.out.println("Size of LL " + size);
        System.out.println("Removed LL First data: " + ll.removeFirst());
        ll.print();
        System.out.println("Removed LL Last data: " + ll.removeLast());
        ll.print();
        System.out.println(ll.search(44));
        System.out.println(ll.recurSearch(4, head));
        // ll.reverseLL();
        System.out.println("Removing Nth Element from the End :   " + ll.deleteNthFromEnd(1));
        ll.print();
        LinkedList.tail.next = head;
        System.out.println(ll.isCycle());
        ll.removeCycle();
        ll.print();

    }
}
