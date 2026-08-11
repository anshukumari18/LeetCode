class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        // Check if there are at least k nodes
        ListNode curr = head;
        int count = 0;

        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If we have k nodes, then reverse them
        if (count == k) {

            curr = reverseKGroup(curr, k);

            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }

            head = curr;
        }

        return head;
    }
}