class Solution {
    enum OPERATION {
        LTE,
        GTE
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }

        // Get the inclusive indices of overlapping indices to be merged.
        int lI = binarySearch(intervals, newInterval[0], OPERATION.LTE);
        int rI = binarySearch(intervals, newInterval[1], OPERATION.LTE);

        //If lI = -1 means we didnt find it.
        int mergeStartIdx = lI, mergeEndIdx = rI;
        int insertAt = -1;
        
        //If newInterval[0] is not present in intervals, find the intervals which can be merged 
        //with newInteval[0]; Accordingly set the insertAt (or) mergeStart.
        if (lI == -1) {
            insertAt = 0;
            if (rI >= 0) {
                mergeStartIdx = 0;
            }
        } else if (intervals[lI][1] < newInterval[0]) {
            insertAt = lI+1;
            mergeStartIdx = (lI +1 > rI) ? -1 : lI + 1;
        }
        
        //Based on the insertAt or mergeStart Indices fill the mergeable/insertable
        int[] mergedInterval = new int[] {};
        int mergedCount = 0;
        
        if (mergeStartIdx != -1 && mergeStartIdx <= mergeEndIdx) {
            mergedInterval = new int[]{Math.min(intervals[mergeStartIdx][0], newInterval[0]),
                    Math.max(intervals[mergeEndIdx][1], newInterval[1])};
            mergedCount = (mergeEndIdx - mergeStartIdx + 1);
        } else {
            mergedInterval = newInterval;
        }

        //Fill the result by just appending the prefixArray + mergedArray/insertedArray + suffixArray
        int[][] intervalsResult = new int[intervals.length - mergedCount + 1][2];

        for (int i = 0; i < intervalsResult.length; i++) {
            if (i == insertAt || i == mergeStartIdx) {
                intervalsResult[i] = mergedInterval;
                
            } else if (i < insertAt || i < mergeStartIdx) {
                intervalsResult[i] = intervals[i];
            } else {
                intervalsResult[i] = intervals[mergedCount + i -1];
            }
        }
        return intervalsResult;
    }

    private int binarySearch(int[][] intervals, int lookFor, OPERATION operation) {
        int l = 0, r = intervals.length -1;
        if (intervals[0][0] > lookFor) {
            return operation.equals(OPERATION.LTE) ? -1 : 0;
        }
        while ( l <= r) {
            int m = (l + r + 1)/2;
            if (intervals[m][0] < lookFor) {
                l = m + 1;
            } else if (intervals[m][0] > lookFor) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return operation.equals(OPERATION.LTE) ? r : l;
    }
}