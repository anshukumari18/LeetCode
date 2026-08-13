class Solution {
    public static void helper(List<Integer> num, List<List<Integer>> res, List<Integer> temp) {
        if (num.size() == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < num.size(); i++) {
            while (i + 1 < num.size() && num.get(i) == num.get(i + 1)) {
                i += 1;
            }
            temp.add(num.get(i));

            List<Integer> newNums = new ArrayList<>(num);
            newNums.remove(i);

            helper(newNums, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        for (int x : nums) {
            num.add(x);
        }
        helper(num, res, temp);
        return res;
    }
}