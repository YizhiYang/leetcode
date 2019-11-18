package LinkedList;


/**
 * the basic idea is to maintain two queues, the first one stores all nodes with val less than x ,
 * and the second queue stores all the rest nodes. Then concat these two queues.
 * Remember to set the tail of second queue a null next, or u will get TLE.
 * <p>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output:       1->2->2->4->3->5
 */
public class PartitionList {


    public ListNode partition(ListNode head, int x) {

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }

        curr1.next = dummy2.next;
        curr2.next = null;

        return dummy1.next;
    }


}
