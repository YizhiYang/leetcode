package Backtracking;


/**
 *
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible,
 * it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples.
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 1， 2， 7， 4， 3， 1
 *
 *
 *
 *
 *
 */


public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int firstSmallIndex = -1;
        for(int i = nums.length - 2; i >= 0; i--){

            if(nums[i] < nums[i + 1]){
                firstSmallIndex = i;
                break;
            }
        }

        if (firstSmallIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmallIndex; i--) {
            if (nums[i] > nums[firstSmallIndex]) {
                firstLarge = i;
                break;
            }
        }

        swap(nums, firstSmallIndex, firstLarge);
        reverse(nums, firstSmallIndex + 1, nums.length - 1);
        return;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i++] = nums[j];
        nums[j--] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
