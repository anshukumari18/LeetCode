class Solution {
    public static void permutation(int[] nums,boolean[] map,List<Integer> ds,List<List<Integer>> ans){
        int x=-11;
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
          if(nums[i]==x) continue;
          if(!map[i]){
            ds.add(nums[i]);
            map[i]=true;
            permutation(nums, map, ds,ans);
            x=ds.get(ds.size()-1);
            ds.remove(ds.size()-1);
            map[i]=false;
          }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] map = new boolean[nums.length];
        Arrays.sort(nums);
        permutation(nums,map,new ArrayList<>(),ans);
        return ans;
    }
}