package GreedyAlgo;

public class LeetCode1221 {

    public static int balancedStringSplit(String str) {

        if (str.length() == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'L') {
                l++;
            } else if (ch == 'R') {
                r++;
            }
            if (l == r) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "RLRRRLLRLL";
        System.out.println(balancedStringSplit(str));
    }
}
