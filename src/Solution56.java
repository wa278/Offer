/*
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Solution56 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        if(pNode.next == null){
            return null;
        }
        if(pNode.next.left ==pNode){
            return pNode.next;
        }
        while (pNode.next != null && pNode.next.right == pNode){
            pNode = pNode.next;
        }
        if(pNode.next == null){
            return null;
        }
        else {
            return pNode.next;
        }
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}