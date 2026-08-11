class Solution {
    public int removeDuplicates(int[] nums) {
        //use two pointers
        if (nums.length == 0) return 0;

        int j = 1; //this is our pointer
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}