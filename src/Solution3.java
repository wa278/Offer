/*
����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
 */
import java.util.ArrayList;
import java.util.Stack;

public class Solution3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop().val);
        }
        return result;
    }


}
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
