/*
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
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
