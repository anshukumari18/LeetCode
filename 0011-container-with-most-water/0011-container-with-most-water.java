class Solution {
    public int maxArea(int[] arr) {
        int max = 0 , i = 0, j = arr.length - 1;
        while(i < j){
            int minH = Math.min(arr[i], arr[j]);
            int test = (j - i) * minH;
            if(max < test) max = test;
            // 2 pointers...
            // Shift the pointer with the smaller height because
            // it has already contributed the maximum it could.
            //
            // Shift either pointer if they have the same height.
            if(arr[i] <= arr[j]) i++ ;
            else j--;
        }
        return max;
    }
}