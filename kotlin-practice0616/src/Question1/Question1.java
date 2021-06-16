package Question1;

import java.util.HashSet;

public class Question1 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = longestSubstring(s);
        System.out.println(res);
    }

    public static int longestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int len = s.length(), res = Integer.MIN_VALUE;

        for (int i = 0, j = 0; i < len; i++) {
            if (set.contains(s.charAt(i))) {

                set.remove(s.charAt(j++));
                i--;
            } else {
                set.add(s.charAt(i));
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}
