package dev.buskopan;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    private static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] arr = {1,4,6,2,7,9,12};
        int target = 21;

        int[] res = getPair(arr,target);

        System.out.println(Arrays.toString(res));
    }

    private static int[] getPair(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            System.out.println(complement);

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(arr[i], i);
        }

        return new int[]{};
    }
}
