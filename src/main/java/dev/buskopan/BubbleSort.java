package dev.buskopan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static int operations = 0;

    public static void main(String[] args) {

        int[] numbers = {7,6,2,1,8,4,2,5,0,3};

        System.out.println(Arrays.toString(bubbleSort(numbers)));
        System.out.println("Made in " + operations + " operations");
    }

    private static int[] bubbleSort(int[] numbers) {
        int temp,i,j;
        boolean swapped;
        for (i = 0; i < numbers.length - 1; i++) {
            System.out.println(Arrays.toString(numbers) + " LOOP EM I");
            swapped = false;
            for (j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j+1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    swapped = true;
                    operations++;
                    System.out.println(Arrays.toString(numbers) + " LOOP EM J");
                }
            }

            if (!swapped) {
                break;
            }
        }
        return numbers;
    }

}
