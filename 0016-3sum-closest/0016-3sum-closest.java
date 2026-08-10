class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;

        int minDiff = Integer.MAX_VALUE;
        int closest = 0;

        for (int i = 0; i < len - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = sum - target;
                int absDiff = diff < 0 ? -diff : diff;

                if (absDiff < minDiff) {
                    minDiff = absDiff;
                    closest = sum;
                }

                if (diff == 0) {
                    return sum;
                } else if (diff > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return closest;
    }
}