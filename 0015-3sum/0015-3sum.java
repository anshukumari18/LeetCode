class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n<3) return new ArrayList<>();
        int left=0,right=0;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            left = i+1;
            right = n-1;
            if(nums[right]<0) return new ArrayList<>();
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;
            while(left<right){
                int total = nums[i]+nums[left]+nums[right];
                if(total<0) left++;
                else if(total>0) right--;
                else{
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}