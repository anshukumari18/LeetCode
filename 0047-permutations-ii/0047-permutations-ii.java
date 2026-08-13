class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); 
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), res, used);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> current, 
                           List<List<Integer>> res, boolean[] used) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            
            if (used[i]) continue;

            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;

            current.add(nums[i]);
            used[i] = true;
            backtrack(nums, current, res, used);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}