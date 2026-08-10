class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        long closestSum = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - closestSum) > Math.abs(target - currentSum)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return currentSum;
                }
            }
        }

        return (int) closestSum;
    }
}