class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        if(n == 1){
            return intervals;
        }

        Arrays.sort(intervals,(a,b) -> {
            return a[0] - b[0];
        });

        List<List<Integer>> result = new ArrayList<>();

        int i = 1;
        int j = 0;

        while(j < n){

            int start = intervals[j][0];
            int end = intervals[j][1];
            
            while((i < n) && (intervals[i][0] <= end)){
                end = Math.max(end,intervals[i][1]);
                i++;
            }

            result.add(Arrays.asList(start,end));

            j = i;
            i++;
        }

        int[][] resArray = new int[result.size()][2];
        for(int k = 0; k < result.size(); k++){
            List<Integer> interval = result.get(k);
            resArray[k][0] = interval.get(0);
            resArray[k][1] = interval.get(1);
        }

        return resArray;        
    }
}