package Microsoft.Phone;

import java.util.*;
import java.util.stream.Collectors;

/*
* O(n)
* O(k)
* */
public class BurgenSort {
    public static void main(String[] args) {
        int[] nums1 = {2, 5, 4, 1, 6};
        int[] nums2 = {4, 9, 1, 2, 7};

        System.out.println(burgenSort(nums1));
        System.out.println(burgenSort(nums2));
    }

    public static List<Integer> burgenSort(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        while (!isSorted(nums))
            randSort(nums);

        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void randSort(int[] nums) {
        Random rand = new Random();
        int index1 = rand.nextInt(nums.length);
        int index2 = rand.nextInt(nums.length);

        // if rand same index we don't have to sort because waste time
        if (index1 != index2) {
            swap(nums, index1, index2);
        }
    }

    private static boolean isSorted(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                return false;
        }
        return true;
    }
}
