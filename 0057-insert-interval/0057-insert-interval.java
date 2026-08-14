class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> list = new ArrayList<>();
        int ind = 0;
        while(ind<len&&newInterval[0]>intervals[ind][1]){
            list.add(new int[] {intervals[ind][0],intervals[ind][1]});
            ind++;
        }
        while(ind<len&&newInterval[1]>=intervals[ind][0]){
            newInterval[0] = Math.min(newInterval[0],intervals[ind][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[ind][1]);
            ind++;
        }
        list.add(newInterval);
        while(ind<len){
            list.add(new int[] {intervals[ind][0],intervals[ind][1]});
            ind++;
        }
        int[][] ans = new int[list.size()][2];
        ind = 0;
        for(int[] ar:list){
            ans[ind][0] = ar[0];
            ans[ind][1] = ar[1];
            ind++;
        }
        return ans;
    }
}