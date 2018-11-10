import java.util.Stack;

/*
输入两个链表，找出它们的第一个公共结点。
 */
public class Solution35 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode index1 = pHead1;
        ListNode index2 = pHead2;
        while (index1 != null){
            index1 = index1.next;
            len1++;
        }
        while (index2 != null){
            index2 = index2.next;
            len2++;
        }
        if(len1 > len2){
            for(int i =0 ; i < len1 - len2; i++){
                pHead1 = pHead1.next;
            }
        }
        else {
            for(int i =0 ; i < len2 - len1; i++){
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
}