package LinkedList;

/**
 * Linkedin
 * <p>
 * <p>
 * <p>
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */

public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lastElement = head;
        int length = 1;
        while (lastElement.next != null) {
            lastElement = lastElement.next;
            length++;
        }
        lastElement.next = head;
        // 1,2,3,4,5,6,7,8,9,10,11  -> 11 - 4 = 7   那就说明 8 是头。
        for (int i = 1; i < length - n % length; i++) { // length - n % length 实际上是找出头是谁
            head = head.next;
        }
        ListNode result = head.next;
        head.next = null;
        return result;
    }
}
