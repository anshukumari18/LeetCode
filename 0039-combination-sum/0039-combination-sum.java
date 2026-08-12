class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> current = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);

            // Use i (not i + 1) because the same element can be chosen multiple times
            backtrack(candidates, target - candidates[i], i);

            current.remove(current.size() - 1);
        }
    }
}