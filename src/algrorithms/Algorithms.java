/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algrorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Java class that illustrates the different types of algorithms
 *
 * @author ryanw
 */
public class Algorithms {

    /**
     *
     * @param array
     */
    public static void dump(int[] array) {
        System.out.printf("This is the array you enter %s", Arrays.toString(array));

    }

    /**
     *
     * @param array is converted to a string using Arrays.toString from
     * java.util.Arrays
     * @return array
     */
    public static int[] convertToInt(String[] array) {

        int[] intArray = new int[array.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);

        }
        return intArray;
    }

    /**
     *
     * @param toConvert
     * @return stringArray
     *
     * Method createStringArray single parameter of type string splits the
     * string based on white space and inputs the return values into a String
     * array Return type String Array
     */
    public static String[] createStringArray(String toConvert) {

        String[] stringArray = toConvert.split(" ");
        return stringArray;
    }

    /**
     *
     * @param array
     * @param find
     */
    public static void binarySearch(int[] array, int find) {
        /**
         * Method return type is void takes in two inputs
         *
         * @param array Integer Array variable to be searched
         * @param find Integer variable to be found the method performs a binary
         * search algorithm with a complexity of log(2N) And prints out if the
         * user specified value is located with the array.
         */
        int position = 0, high = array.length - 1, low = 0;

        while (low <= high) {
            int middle = (high + low) / 2;

            if (array[middle] > find) {
                high = middle - 1;
            } else if (array[middle] < find) {
                low = middle + 1;
            } else if (array[middle] == find) {
                System.out.printf("The desired value = %d found at position %d.%n", find, middle);
                return;
            }
        }
        System.out.printf("The desired value = %d is not located in the array.", find);

    }

    /**
     * Multipurpose factory method that calls the static methods located with in
     * the class ie. createStringArray, convertToInt 
     *
     * @param numberString value to pass to the other methods
     * @param find value to pass to the other methods
     * prints out method calls
     */
    public static void numberFactory(String numberString, int find) {

        String[] stringArray = createStringArray(numberString);
        int[] numberArray = convertToInt(stringArray);
        System.out.printf("Array before sorting %n%n");
        dump(numberArray);
        System.out.printf("%n%n");
        sort(numberArray);
        dump(numberArray);
        System.out.printf("%n%nPerforming binary search now to find %d%n", find);
        binarySearch(numberArray, find);

    }
    /**
     * Method performs a bubblesort on the specified array
     * with a complexity of N**2
     * @param array the variable to short
     */
    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }
        /**
     * Method performs a selectionSort on the specified array
     * with a complexity of N**2
     * @param array the variable to short
     */
    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    min = j;

                }

            }
            if (min != i) {
                swap(array, i, min);
            }

        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     *
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    swap(array, i, j);
                }
            }
        }
    }

    /**
     *
     * @param array
     */
    public static void inserttionSort(int[] array) {

        int a, b;
        for (int i = 1; i < array.length; i++) {
            a = array[i];

            b = i;

            while (b > 0 && array[b - 1] > a) {

                array[b] = array[b - 1];
                b--;

            }
            array[b] = a;
        }
    }

    /**
     *
     * @param first
     * @param second
     */
    public static void matrixMath(int first[][], int second[][]) {
        int results[][] = new int[first.length][];

        for (int i = 0; i < results.length; i++) {

            results[i] = new int[second[0].length];

        }

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second[0].length; j++) {
                for (int k = 0; k < first[0].length; k++) {

                    results[i][j] += first[i][k] * second[k][j];

                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter desired array using spaces as delimiter");
        String numbers = input.nextLine();

        System.out.println("Please enter the number to find");
        int findNumber = input.nextInt();

        numberFactory(numbers, findNumber);
    }
}
