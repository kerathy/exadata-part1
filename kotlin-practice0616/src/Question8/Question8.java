package Question8;

public class Question8 {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates(arr);
        System.out.println(res);

    }

    public static int removeDuplicates(int[] arr) {
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[count - 1]) {
                arr[count++] = arr[i];
            }
        }
        return count;
    }
}
