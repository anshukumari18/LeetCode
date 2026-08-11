class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        int low = 0; // pointer starts at index 0 ---> it points to the last unique element encountered
        int high = 1; // pointer starts from index 1 - because index 0 is unique always ---> loops forward to find the next unique element on the basis of comparison with the current low value
        int uniqueCount = 1; // the first element will always be unique

        while (high < n) { // the function can run until the last index of the array and then terminated
            // if the current unique value and the encountered value are equal ---> it's a duplicate --> increment high --> continue
            if(nums[high] == nums[low]){
                high ++;
                continue;
            }
            // if the current unique value and the encountered value are NOT equal ---> it's a new unique --> increment low --> increment uniqueCount --> increment high 
            else{
                nums[low + 1] = nums[high]; // place the new unique element in the index next to low --> [low+1]
                low++; 
                uniqueCount++;
                high++;
            }
        }
        return uniqueCount;
    }
}