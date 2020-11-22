/**
 * @see <a href=
 *      "https://leetcode.com/explore/featured/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3517/">some
 *      other link</a>
 * 
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public static ListNode placeElementInRightPosition(ListNode nodeToBeSorted, ListNode head) {
        if (head.val > nodeToBeSorted.val) {
            return null;
        }
        while (head != nodeToBeSorted) {
            if (head.next.val > nodeToBeSorted.val) {
                return head;
            }
            head = head.next;
        }
        return head;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode nodeToBeSorted = head;
        ListNode temp = head;
        while (nodeToBeSorted != null) {

            ListNode placedPosition = placeElementInRightPosition(nodeToBeSorted, head);
            if (placedPosition != nodeToBeSorted) {
                temp.next = nodeToBeSorted.next;
                if (placedPosition == null) {
                    nodeToBeSorted.next = head;
                    head = nodeToBeSorted;
                } else {
                    nodeToBeSorted.next = placedPosition.next;
                    placedPosition.next = nodeToBeSorted;
                }
            }
            temp = nodeToBeSorted;
            nodeToBeSorted = nodeToBeSorted.next;
        }
        return head;
    }
}