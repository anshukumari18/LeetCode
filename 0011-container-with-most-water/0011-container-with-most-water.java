class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int area = 0;
        int high = 0;

        while (left < right) {
            high = Math.min(height[left], height[right]);
            area = Math.max(area, high * (right - left));

            // Move past lines that are not taller than current min height
            while (left < right && height[left] <= high) left++;
            while (left < right && height[right] <= high) right--;
        }

        return area;
    }
}