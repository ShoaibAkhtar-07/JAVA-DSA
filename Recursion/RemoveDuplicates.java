package Recursion;

public class RemoveDuplicates {
    // public static void removingDuplicates(String str) {
    // boolean[] newArr = new boolean[26];
    // for (int i = 0; i < str.length(); i++) {
    // char ch = str.charAt(i);
    // int index = ch - 'a';
    // newArr[index] = true;
    // }
    // for (int i = 0; i < 26; i++) {
    // if (newArr[i]) {
    // System.out.print((char) ('a' + i));
    // }
    // }

    // }

    public static void removingDuplicates(String str, int idx, StringBuilder newstr, boolean[] map) {
        if (idx == str.length()) {
            System.out.print(newstr);
            return;
        }
        char currChar = str.charAt(idx);

        if (map[currChar - 'a']) {
            removingDuplicates(str, idx + 1, newstr, map);
        } else {
            map[currChar - 'a'] = true;
            removingDuplicates(str, idx + 1, newstr.append(currChar), map);
        }
    }

    public static void main(String[] args) {
        String name = "apnacollege";
        removingDuplicates(name,0,new StringBuilder(),new boolean[26]);
    }
}
