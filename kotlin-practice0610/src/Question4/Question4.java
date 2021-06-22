package Question4;

import java.util.Arrays;
import java.util.Scanner;

public class Question4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

//        System.out.println(Arrays.toString(arr));
        int res = bubbleSort(arr);
        System.out.println("Array is sorted in " + res + " swaps");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[size - 1]);
        
    }

    public static int bubbleSort(int[] arr) {
        int len = arr.length;
        int count = 0;
        for (int i = 0; i <= len - 2; i++) {
            for (int j = 0; j <= len - 2 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j+1, arr);
                    count++;
                }
            }
        }
        return count;
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
