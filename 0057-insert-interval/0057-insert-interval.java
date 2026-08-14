class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int []>ansArray=new ArrayList<>();
        int i=0;
        while(i<intervals.length && intervals[i][1]<newInterval[0])
        {
            ansArray.add(intervals[i]);
            i++;
        }

        int []temp=new int[2];
        temp[0]=newInterval[0];
        temp[1]=newInterval[1];
        while(i<intervals.length && newInterval[1]>=intervals[i][0])
        {
            temp[0]=Math.min(temp[0],intervals[i][0]);
            temp[1]=Math.max(temp[1],intervals[i][1]);
            i++;
        }
        ansArray.add(temp);
        while(i<intervals.length)
        {
            ansArray.add(intervals[i]);
            i++;
        }

        int [][]newInsertInterval=new int[ansArray.size()][];
        
        for(int idx=0;idx<ansArray.size();idx++)
        {
            newInsertInterval[idx]=ansArray.get(idx);
        }
        return newInsertInterval;
    }
}