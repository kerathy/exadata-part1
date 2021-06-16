package Question7;

public class Question7 {

    public static void main(String[] args) {
        int[] arr = {1};
        int res = findInsertedPostion(arr, 0);
        System.out.println(res);
    }

    public static int findInsertedPostion(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
