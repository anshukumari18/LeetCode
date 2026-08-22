class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, ans = 0;
        int[] pre = new int[n];
        int[] post = new int[n];
        Arrays.fill(post, n);

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                post[st.peek()] = i;
                st.pop();
            }

            pre[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        for(int i = 0; i < n; i++){
            int width = post[i] - pre[i] - 1;
            ans = Math.max(ans, heights[i] * width);
        }

        return ans;
    }
}