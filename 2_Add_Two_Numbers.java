/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // corner case
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        // basic idea:
        // build the node for cur digit
        // let an integer (sum) indicate next round 0 or 1
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if (sum / 10 == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}