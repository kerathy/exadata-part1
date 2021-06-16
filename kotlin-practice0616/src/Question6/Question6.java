package Question6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] strArr = str.split(" ");
        int len = strArr.length;
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = Integer.valueOf(strArr[i]);
        }
        int target = sc.nextInt();
        int res = searchInRotatedArray(arr, target);
        System.out.println(res);
    }

    public static int searchInRotatedArray(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (arr[mid] <= arr[end]) {
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
