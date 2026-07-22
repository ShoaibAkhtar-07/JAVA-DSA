package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Interleave2Halves {
    public static Queue<Integer> interleave(Queue<Integer> q) {
        int size = q.size();
        int half = size / 2;
        Queue<Integer> nq = new LinkedList<>();
        for (int i = 0; i < half; i++) {
            nq.add(q.remove());
        }

        while (!nq.isEmpty()) {
            q.add(nq.remove());
            q.add(q.remove());
        }
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        System.out.print(interleave(q));
    }
}
