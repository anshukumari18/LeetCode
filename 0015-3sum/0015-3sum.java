class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // in this we have to find the triplet and  i != j, i != k, and j != k
        //first this is that we have to create a ans list
        // we have to sort a array
        // in this we are using a 2 pointer approach 
        // we have to take care of duplicates 
        // add i , j,k in the list  

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
          
          int n = nums.length;
        // remove duplicates
        for(int i = 0; i <n ; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
        

        // we have to create a pointers 
        int j = i+1;
        int k = n-1;
       
       while(j<k){
        int sum = nums[i] + nums[j] + nums[k];
        if(sum <0){
            j++;
        } else if(sum>0){
            k--;
        } else{
       

       // we have to store the list in the ans
       List<Integer> temp =  Arrays.asList(nums[i],nums[j], nums[k]);
           ans.add(temp);
           j++;
           k--;

        // remove duplicates
        while(j<k && nums[j] == nums[j-1])j++;
        while(j<k && nums[k] == nums[k+1])k--;
        }
       }

    }
    return ans;
   
    }
}