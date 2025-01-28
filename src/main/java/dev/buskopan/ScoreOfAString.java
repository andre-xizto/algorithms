package dev.buskopan;

public class ScoreOfAString {

    public static void main(String[] args) {
        String input = "hello";

        System.out.println(getScore(input));
    }

    private static int getScore(String input) {

        int result = 0,value1,value2;

        for (int i = 0; i < input.length() - 1; i++) {
            value1 = input.charAt(i);
            value2 = input.charAt(i + 1);
            result += Math.abs(value1 - value2);
        }

        return result;

    }

}
