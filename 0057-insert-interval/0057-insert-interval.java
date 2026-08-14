class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int []> al=new ArrayList<>();
        int i=0;
        for(i=0;i<intervals.length;i++){
            if(intervals[i][1]<newInterval[0]){
                al.add(intervals[i]);
            }
            else if(intervals[i][0]>newInterval[1]){
                break;
            }
            else{
                newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
                newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            }
        }
        al.add(newInterval);
        
        while(i<intervals.length){
            al.add(intervals[i]);
            i++;
        }
        return al.toArray(new int[al.size()][]);

    }
}