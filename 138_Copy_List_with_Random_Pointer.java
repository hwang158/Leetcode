/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // corner case
        if (head == null) {
            return null;
        }
        
        //iterate one time of the list to copy each node with next pointer
        //the copy is directly following with the original node
        RandomListNode iter = head;
        while (iter != null) {
            RandomListNode temp = iter.next;
            RandomListNode copy = new RandomListNode(iter.label);
            copy.next = temp;
            iter.next = copy;
            iter = temp;
        }
        
        //copy the random pointer in each copy node to point to the next node of random node (copy of it)
        iter = head;
        while (iter != null) {
            //careful with the null point without next pointer
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        
        //Start to separate the linked list to orignal one and deep copy one
        RandomListNode copyList = new RandomListNode(0);
        RandomListNode orig = head;
        RandomListNode next = copyList;  
        while (orig != null) {
            RandomListNode temp = orig.next;
            next.next = temp;
            orig.next = temp.next;
            next = temp;
            orig = temp.next;
        }
        
        return copyList.next;
    }
}

/**
 * The complexity is O(n), three while loop to go through each node
 * The space complexity is O(n), creating deep copy list and an extra leading node
 */