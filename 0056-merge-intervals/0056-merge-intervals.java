class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
		    if(a[0]!=b[0]) return a[0] - b[0];
		    else return a[1]-b[1];
		    });

        int start = intervals[0][0];
        int end = intervals[0][1];
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];

        List<int[]> list = new ArrayList<>();

        int i = 0, n = intervals.length;
        while(i < n-1) {
            if(end < currEnd) {
                end = currEnd;
            }
            i++;
            currStart = intervals[i][0];
            currEnd = intervals[i][1];
            if(end < currStart) {
                list.add(new int[] {start, end});
                start = currStart;
                end = currEnd;
            }
        }
        if(end < intervals[i][1]){
            end = intervals[i][1];
        }
        list.add(new int[] {start, end});

        int[][] output = new int[list.size()][2];
        for(int k = 0; k < list.size(); k++) {
            output[k][0] = list.get(k)[0];
            output[k][1] = list.get(k)[1];
        }
        return output;
    }
}