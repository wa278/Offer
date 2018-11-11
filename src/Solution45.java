/*
圆圈中最后剩下的数字。n个数字排成一个圆圈，从0开始删除第m个数字。求出最后一个数字
 */
public class Solution45 {
    public int LastRemaining_Solution(int n, int m) {
        ListNode head = new ListNode(0);
        ListNode index = head;
        for(int i = 1; i <n;i++){
            index.next = new ListNode(i);
            index = index.next;
        }
        index.next = head;
        while (head.next!=head){
            for(int i = 0; i < m-1; i++){
                head = head.next;
            }
            deleteNode(head);
        }
        return head.val;
    }
    public void deleteNode(ListNode node){
        if(node.next == null){
            node = null;
        }
        else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        Solution45 x = new Solution45();
        System.out.println(x.LastRemaining_Solution(5,3));
    }
}
