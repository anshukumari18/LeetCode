class Solution {
    private void permuteUniqueUtil(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] used){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;

            if(i>0 && nums[i-1] == nums[i] && !used[i-1]) continue; //Skip a duplicate number if its previous identical number is not used yet.

            if(!used[i]){
                used[i] = true;
                ds.add(nums[i]);
                permuteUniqueUtil(nums, ans, ds, used);
                ds.remove(ds.size()-1);
                used[i]= false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> ds = new ArrayList<>();
       boolean[] used = new boolean[nums.length];
       //Important 
       Arrays.sort(nums);
       permuteUniqueUtil(nums, ans, ds, used);
       return ans;
    }
}