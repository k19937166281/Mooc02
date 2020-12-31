package suanfa;

import java.util.Arrays;
public class Solution3 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Integer[] merge = new Integer[nums1.length+nums2.length];
        int index = -1;
        for (int i : nums1) {
            merge[++index]=i;
        }
        for (int i : nums2) {
            merge[++index]=i;
        }

        Arrays.sort(merge);

        return merge.length%2==0?Double.valueOf(merge[merge.length/2-1]+merge[merge.length/2])/2:merge[merge.length/2];
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        int[] b = {3,4};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
