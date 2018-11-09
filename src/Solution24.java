/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution24 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode head = pHead;

        while (head!=null){
            RandomListNode temp = head.next;
            RandomListNode dup = new RandomListNode(head.label);
            head.next = dup;
            dup.next = temp;
            head = temp;
        }
        head = pHead;
        while (head != null){
            RandomListNode dup = head.next;
            if(head.random != null){
                dup.random = head.random.next;
            }
            head = dup.next;
        }
        RandomListNode result = new RandomListNode(0);
        RandomListNode temp = result;
        head = pHead;
        while (head != null){
            RandomListNode dup = head.next;
            temp.next = dup;
            head.next = dup.next;
            head = head.next;
            temp = temp.next;
        }
        return result.next;

    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}