package dev.buskopan;

import java.util.Arrays;

public class BinarySeach {
    private static int operations = 0;
    public static void main(String[] args) {
        int[] numbers = {43243,5546,5474,34,6,23,753,754,754,2,532,4,314,3,46,54,658,8,56,4536,34,56,867,987,95,95,47,36,345,34};
        Arrays.sort(numbers);
        int target = 658;

        System.out.println(normalSearch(numbers,target));
        System.out.println("Search made in " + operations + " operations in normal search");

        reset();

        System.out.println(binarySearch(numbers,target));
        System.out.println("Search made in " + operations + " operations in binary search");

    }

    private static int normalSearch(int[] list, int target) {
        for (int i = 0; i < list.length; i++) {
            operations++;
            if (list[i] == target) return list[i];
        }
        return 0;
    }

    private static int binarySearch(int[] list, int target) {
        operations++;
        int index = (list.length / 2);
        int number = list[index];
        if (number == target) return number;
        if (number > target) return binarySearch(Arrays.copyOfRange(list, 0, index), target);
        return binarySearch(Arrays.copyOfRange(list, ++index, list.length), target);
    }

    private static void reset() {
        operations = 0;
    }
}
