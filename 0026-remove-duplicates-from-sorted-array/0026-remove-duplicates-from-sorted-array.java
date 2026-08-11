class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int lo=0;int curr=0;
        while(curr<n){
            int j=curr+1;
            while(j<n && nums[j]==nums[curr])j++;
            nums[lo]=nums[curr];
            lo++;
            curr=j;

        }
        return lo;
    }
}