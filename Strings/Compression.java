package Strings;

public class Compression {

    public static void compress(String str) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(ch);
            if (count > 1) {
                sb.append(count);
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        String str = "aaabbcccdde";
        compress(str);
    }
}
