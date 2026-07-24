package Queue;

public class LeetCode134 {

    public static int gasStation(int gas[], int cost[]) {
        for (int i = 0; i < gas.length; i++) {
            int petrol = 0;
            for (int j = 0; j < gas.length; j++) {

                int idx = (i + j) % gas.length;
                petrol += gas[idx];
                petrol -= cost[idx];
                if (petrol < 0) {
                    break;
                }
            }
            if (petrol >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        System.out.println(gasStation(gas, cost));
    }
}
