package at.htl;

import java.util.Random;
import java.util.Scanner;

public class SortComplexity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int anzahlArrays;
        int sizeArrays;
        long zeit, averageTime = 0;

        System.out.print("Anzahl der zu sortierenden Arrays: ");
        anzahlArrays = scanner.nextInt();
        System.out.print("Größe der Arrays: ");
        sizeArrays = scanner.nextInt();

        for (int i = 1; i <= anzahlArrays; i++) {
            zeit = sortRandomArray(sizeArrays);
            System.out.printf("\nLaufzeit zur Sortierung des %2s. Arrays: %s ms", i, zeit);
            averageTime += zeit;
        }

        averageTime /= anzahlArrays;
        System.out.printf("\n\nDurchschnittliche Laufzeit: %s ms", averageTime);
    }

    // Sorts an array of random numbers and returns the sorting run time in ms
    public static long sortRandomArray(int length) {
        int[] intArray;
        long vor, nach, zeit;
        
        intArray = generateRandomArray(length);
        vor = System.currentTimeMillis();
        sort(intArray);
        nach = System.currentTimeMillis();

        zeit = nach - vor;
        
        return zeit;
    }

    // Returns an array of random numbers
    public static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] intArray = new int[length];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt();
        }

        return intArray;
    }

    // Sorts an array of numbers in ascending order
    public static void sort(int[] array) {
        int i = array.length - 1;
        
        do {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, i, j);
                }
            }
            i--;
        } while ((i >= 0));
    }

    // Swaps the array elements with index i and j
    public static void swap(int[] array, int i, int j) {
        int hilf = array[j];
        array[j] = array[j + 1];
        array[j + 1] = hilf;
    }
}
