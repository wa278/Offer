/*
输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution13 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head ==null){
            return null;
        }
        if( k == 0){
            return null;
        }
        ListNode index = head;

        for(int i = 0; i< k-1;i++){
            index = index.next;
            if(index == null){
                return null;
            }
        }
        while (index.next != null){
            index = index.next;
            head = head.next;
        }
        return head;
    }
}
