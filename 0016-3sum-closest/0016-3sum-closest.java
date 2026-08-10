class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minAbsDif=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<nums.length-2;i++){
            int newTar=target-(nums[i]);
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[left]+nums[right];
                if(minAbsDif>Math.abs(newTar-sum)){
                    minAbsDif=Math.abs(newTar-sum);
                    ans=nums[i]+sum;
                }
                if(sum>newTar){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return ans;
    }
}