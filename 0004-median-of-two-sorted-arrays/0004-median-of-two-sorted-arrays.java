class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array so binary search range is minimized
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2; // size of left partition (handles odd/even)

        int lo = 0, hi = m;

        while (lo <= hi) {
            int partition1 = (lo + hi) / 2;          // elements taken from nums1 into left half
            int partition2 = totalLeft - partition1;  // elements taken from nums2 into left half

            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Correct partition found
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                hi = partition1 - 1; // too many elements from nums1 on the left, move left
            } else {
                lo = partition1 + 1; // too few elements from nums1 on the left, move right
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}