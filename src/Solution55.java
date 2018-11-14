/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution55 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        else if(pHead.next.val == pHead.val){
            int k = pHead.val;
            while (pHead != null && pHead.val == k){
                pHead = pHead.next;
            }
            return deleteDuplication(pHead);
        }
        else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        x.next = new ListNode(1);
        Solution55 a = new Solution55();
        System.out.println(a.deleteDuplication(x));
    }
}
