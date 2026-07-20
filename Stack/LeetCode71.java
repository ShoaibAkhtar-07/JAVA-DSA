package Stack;

import java.util.Stack;

public class LeetCode71 {
    public static String simplifyPath(String str) {
        Stack<String> s = new Stack<>();
        String[] parts = str.split("/");
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(part);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String dir : s) {
            ans.append("/").append(dir);
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }

    public static void main(String[] args) {
        String str = "/home/user/Documents/../Pictures";
        System.out.print(simplifyPath(str));
    }
}
