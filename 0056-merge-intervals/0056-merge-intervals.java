class Solution {
   public int[][] merge(int[][] intervals) {
        int numberOfMerging = 0;
        int [][] result = new int[intervals.length][2];
        quicksort(intervals, 0, intervals.length - 1);
        int j = 0;
        if(intervals.length != 0){
            result[0][0] = intervals[0][0];
            result[0][1] = intervals[0][1];
        }
        for (int i = 1; i < intervals.length; i++) {
            if(result[j][1] >= intervals[i][0]){
                result[j][1] = Math.max(result[j][1], intervals[i][1]);
                numberOfMerging++;
                continue;
            }
            j++;
            result[j][0] = intervals[i][0];
            result[j][1] = intervals[i][1];
        }
        int [][] finishResult = new int[intervals.length - numberOfMerging][2];
        for (int i = 0; i < finishResult.length; i++) {
            finishResult[i][0] = result[i][0];
            finishResult[i][1] = result[i][1];
        }
        return finishResult;
    }

    private static void quicksort (int [][] arr, int low, int high){
        if(arr.length == 0 || high < low) return;
        int mid = low + (high - low) / 2;

        int midEl = arr[mid][0];
        int i = low, j = high;
        while(i <= j){
            while(arr[i][0] < midEl) i++;
            while(arr[j][0] > midEl) j--;

            if(i <= j) {
                int temp = arr[i][0];
                int temp2 = arr[i][1];
                arr[i][0] = arr[j][0];
                arr[i][1] = arr[j][1];
                arr[j][0] = temp;
                arr[j][1] = temp2;
                i++;
                j--;
            }
        }
        quicksort(arr, low ,j);
        quicksort(arr, i, high);
    }
}