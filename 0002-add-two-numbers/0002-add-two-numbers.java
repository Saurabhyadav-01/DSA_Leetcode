/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node
        ListNode dummy = new ListNode(0);

        // Current pointer for result list kyunki time ke saath current khisak kar tail tak jayega but dummy head par hi rahega
        ListNode current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            // Add first list value
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add second list value
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Calculate digit and carry
            int digit = sum % 10;
            carry = sum / 10;

            // Create new node
            current.next = new ListNode(digit);

            // Move current pointer
            current = current.next;
        }

        return dummy.next;
    }
}
