class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        helper(0, nums, res, visited, temp);
        return res;
    }

    public void helper(int i, int[] nums, List<List<Integer>> res, Set<Integer> visited, List<Integer> temp) {
        if(i==nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int k=0;k<nums.length;k++)
        {
            if(k>0 &&  nums[k]==nums[k-1] && !visited.contains(k-1)) continue;
            if(!visited.contains(k))
            {
                visited.add(k);
                temp.add(nums[k]);
                helper(i+1, nums, res, visited, temp);
                temp.remove(temp.size()-1);
                visited.remove(k);
            }
        }
    }
}