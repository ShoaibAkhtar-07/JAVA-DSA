import java.util.LinkedList;

public class RemovingNNodes {

    public static LinkedList<Integer> RemoveNNodes(LinkedList<Integer> orgLL, int m, int n) {
        int index = m;
        while (index < orgLL.size()) {
            for (int i = 0; i < n && index < orgLL.size(); i++) {
                orgLL.remove(index);
            }
            index += m;
        }

        return orgLL;
    }

    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);

        System.out.print(RemoveNNodes(ll, 2, 2));

    }
}
