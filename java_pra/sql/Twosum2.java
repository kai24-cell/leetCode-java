public class Twosum2 {
    int nums[] = { 2, 7, 11, 15 };
    int target = 9;
    Solution x = new Solution();
    int output[] = x.twoSum(nums, target);
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};

    }
}