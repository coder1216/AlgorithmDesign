package Microsoft.OA;

import java.util.*;

class MicrosoftOA2 {
    public static void main(String[] args) {
        String s1 = "ab";
        int[] nums1 = {1,3};
        String s2 = "abccbd";
        int[] nums2 = {0,1,2,3,4,5};
        String s3 = "aabbcc";
        int[] nums3 = {1,2,1,2,1,2};
        String s4 = "aaaa";
        int[] nums4 = {3,4,5,6};
        String s5 = "ababa";
        int[] nums5 = {10,5,10,5,10};
        System.out.println(getMinCost(s1, nums1));
        System.out.println(getMinCost(s2, nums2));
        System.out.println(getMinCost(s3, nums3));
        System.out.println(getMinCost(s4, nums4));
        System.out.println(getMinCost(s5, nums5));
    }

    public static int getMinCost(String str, int[] nums) {
        if (str == null || str.length() == 0 || nums == null || nums.length == 0) throw new IllegalArgumentException("input invalid!");

        int res = 0;
        // if we have 2 same value which is continue, get the max cost
        int max = nums[0];
        // current max cost
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i - 1);
            // if same, get the max cost
            if (ch1 == ch2) {
                sum += nums[i];
                max = Math.max(max, nums[i]);
            } else {
                // if not same, update sum and max, get min cost through sum - max cost, add it into res
                res += sum - max;
                max = nums[i];
                sum = nums[i];
            }
        }
        // add min cost
        res += sum - max;
        return res;
    }
}
