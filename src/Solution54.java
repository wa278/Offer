/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Solution54 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        int k =0;
        ListNode one = pHead;
        ListNode two = pHead;
        while (two != null){
            if(two.next!=null && two.next.next != null){
                two = two.next.next;
            }
            else {
                return null;
            }
            one = one.next;
            k++;
            if(one == two){
                break;
            }
        }
        one = pHead;
        two = pHead;
        for(int i = 0; i <k; i++){
            one = one.next;
        }
        while (one != two){
            one = one.next;
            two = two.next;
        }
        return one;
    }

    public static void main(String[] args) {
        Solution54 x = new Solution54();
        x.EntryNodeOfLoop(null);
    }
}
