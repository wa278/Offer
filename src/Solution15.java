import java.util.List;

/*
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution15 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode result =new ListNode(0);
        ListNode index = result;
        while (list1 != null || list2 !=null){
            if(list1 == null){
                index.next = list2;
                list2 = list2.next;
                index = index.next;
            }
            else if(list2 == null){
                index.next = list1;
                list1 = list1.next;
                index = index.next;
            }
            else if(list1.val < list2.val){
                index.next = list1;
                list1 = list1.next;
                index = index.next;
            }
            else {
                index.next = list2;
                list2 = list2.next;
                index = index.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(3);
        a.next.next = new ListNode(5);
        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(5);
        Solution15 x = new Solution15();
        x.Merge(a,b);
    }
}
