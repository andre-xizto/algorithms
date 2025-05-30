package dev.buskopan;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {

        String roman = "IM";

        System.out.println(toInt(roman));

    }

    private static int toInt(String roman) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        char[] arr = roman.toCharArray();
        int result = 0;
        for (int i = 0; i < arr.length-1; i++) {
            char actual = arr[i];
            char next = arr[i+1];

            if (map.get(actual) < map.get(next)) {
                result -= map.get(actual);
            } else {
                result += map.get(actual);
            }
        }

        result += map.get(arr[arr.length - 1]);
        return result;
    }


}
