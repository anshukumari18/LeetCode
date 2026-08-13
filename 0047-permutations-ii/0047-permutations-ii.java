class Solution {
    public List<List<Integer>> permuteUnique(int[] arr) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(arr);
        boolean used[]=new boolean[arr.length];
        fun(new ArrayList<>(),used,res,arr);
        return res;
    }

    public void fun(List<Integer> li,boolean used[],List<List<Integer>> res,int arr[]){
        if(li.size()==arr.length){
            res.add(new ArrayList<>(li));
            return;
        }

        int lastused=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(used[i]==false && lastused!=arr[i]){
                used[i]=true;
                li.add(arr[i]);
                lastused=arr[i];
                fun(li,used,res,arr);
                used[i]=false;
                li.remove(li.size()-1);
            }
        }
    }
}