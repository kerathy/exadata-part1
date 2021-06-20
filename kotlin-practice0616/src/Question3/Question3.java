package Question3;

public class Question3 {

    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2};
        double res = medianOfTwoSortedArray(arr1, arr2);
        System.out.println(res);
    }

    public static double medianOfTwoSortedArray(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, len = len1 + len2;

        if (len1 > len2) {
            return medianOfTwoSortedArray(nums2, nums1);
        }

        int cut1 = 0, cut2, start = 0, end = len1;

        while (cut1 <= len1) {
            cut1 = start + (end - start) / 2;
            cut2 = len / 2 - cut1;

            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double R1 = (cut1 == len1) ? Integer.MAX_VALUE : nums1[cut1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R2 = (cut2 == len2) ? Integer.MAX_VALUE : nums2[cut2];

            if (L1 > R2) {
                end = cut1 - 1;
            } else if (L2 > R1) {
                start = cut1 + 1;
            } else {
                if (len % 2 == 0) {
                    return ((L1 > L2 ? L1 : L2) + (R1 < R2 ? R1 : R2)) / 2;
                } else {
                    return R1 < R2 ? R1 : R2;
                }
            }
        }
        return -1;
    }
}
