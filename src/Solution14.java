import java.util.Stack;

/*
输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution14 {
    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode result = head;
        ListNode next;
        while (result.next != null){
            next = result.next;
            result.next = pre;
            pre = result;
            result = next;
        }
        result.next = pre;
        return result;
    }
}
