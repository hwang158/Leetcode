/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 //Use stack to get all values
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l1.val == 0) {
            return l2;
        }
        if (l2 == null || l2.val == 0) {
            return l1;
        }
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        //loop creating a list from last node
        ListNode list = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int temp = a + b + list.val;
            list.val = (temp) % 10;
            //indicate previous node needs an extra 1
            ListNode head = new ListNode(temp / 10);
            head.next = list;
            list = head;
        }
        //last loop will create a zero node if two list length is not equal
        return list.val == 0 ? list.next : list;
    }
}

// Solution 2:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Note: int is not larger enough
// Need to consider
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = linkListToInt(l1);
        int b = linkListToInt(l2);
        int sum = a + b;
        return intToLinkList(sum);
    }
    
    private int linkListToInt(ListNode l) {
        if (l == null || l.val == 0) {
            return 0;
        }
        int res = 0;
        while (l != null) {
            res = res * 10 + l.val;
            l = l.next;
        }
        return res;
    }
    
    private ListNode intToLinkList(int sum) {
        if (sum == 0) {
            return new ListNode(0);
        }
        
        ListNode leading = new ListNode(0);
        ListNode iter = null;
        while (sum != 0) {
            ListNode tail = new ListNode(sum % 10);
            leading.next = tail;
            tail.next = iter;
            iter = tail;
            sum /= 10;
        }
        return leading.next;
    }
}
