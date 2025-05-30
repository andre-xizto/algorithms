package dev.buskopan;

import java.util.*;

public class LevenshteinDistance {

    public static void main(String[] args) {
        Map<Integer, String> results = new TreeMap<>();
        String[] events = {"Lollapalooza", "Rock in Rio", "Taylor Swift", "The town", "Madonna", "RBD", "System of a down"};
        String input = "THE CITI";
//        for (String event : events) {
//            int distance = distance(input, event);
//            if (distance <= input.length() * 2) results.put(distance,event);
//        }
//        System.out.println(results);
        String input2 = "THE CITY";
        distance(input,input2);
    }

    public static int distance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else {
                    int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1,dp[i][j - 1] + 1),dp[i - 1][j - 1] + cost);
                }
                System.out.println("i: " + i + "; j: " + j + "; dp: " + dp[i][j]);
            }
        }

        return dp[a.length()][b.length()];
    }
}
