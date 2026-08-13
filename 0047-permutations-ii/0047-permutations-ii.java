class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<List<Integer>>();
    
        dfs(0, nums);
        
        return res;
            
    }
    
    private void dfs(int idx, int[] nums){
        if(idx == nums.length - 1){
            List<Integer> list = new ArrayList<>();
            for(int i : nums){
                list.add(i);
            }
            
            res.add(list);
            return;
        }
        dfs(idx + 1, nums);
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = idx + 1; i < nums.length; i++){
            
            if(nums[idx] != nums[i] && set.add(nums[i])){
                swap(idx, i, nums);
                dfs(idx + 1, nums);
                swap(idx, i, nums);
            }
        }
    }
    
    private void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    
}