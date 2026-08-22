class Solution {
    int n;

    // Nearest Smaller to Right
    public int[] getNSR(int[] heights) {
        int[] NSR = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            NSR[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return NSR;
    }

    // Nearest Smaller to Left
    public int[] getNSL(int[] heights) {
        int[] NSL = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            NSL[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return NSL;
    }

    public int largestRectangleArea(int[] heights) {
        n = heights.length;
        int[] NSR = getNSR(heights);
        int[] NSL = getNSL(heights);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = NSR[i] - NSL[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}