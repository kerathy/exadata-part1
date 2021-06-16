package Question2;

import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = longestPalindrome(s);
        System.out.println(res);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int len = s.length();
        String res = "";
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = (s.charAt(i) == s.charAt(j)) && ((i - j < 2) || dp[j + 1][i - 1]);
                if (dp[j][i]) {
                    String cur = s.substring(j, i + 1);
                    if (cur.length() > res.length()) {
                        res = cur;
                    }
                }
            }
        }
        return res;
    }
}
