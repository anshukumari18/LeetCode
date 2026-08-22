class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> result) {
        // Add the current subset
        result.add(new ArrayList<>(curr));

        // Explore choices
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            // Choose element
            curr.add(nums[i]);

            // Recurse
            backtrack(nums, i + 1, curr, result);

            // Undo choice (backtrack)
            curr.remove(curr.size() - 1);
        }
    }
}