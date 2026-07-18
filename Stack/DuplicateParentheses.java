package Stack;

import java.util.Stack;

public class DuplicateParentheses {

    public static boolean duplicatePare(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ')') {
                st.push(ch);
            } else {
                int count = 0;
                while (st.peek() != '(') {
                    st.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                }
                st.pop();
            }
        }
        while (!st.isEmpty()) {
            if (st.peek() == '(') {
                throw new IllegalArgumentException("Unbalanced parentheses");
            }
            st.pop();
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "(((a+b) + (c))";
        System.out.println(duplicatePare(str));
    }
}
