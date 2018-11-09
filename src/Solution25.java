/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
// TODO: 2018/11/4  
public class Solution25 {
    TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        inOrder(pRootOfTree);
        while (pre.left !=null){
            pre = pre.left;
        }
        return pre;
    }

    public void inOrder(TreeNode pRootOfTree) {
        if (pRootOfTree.left != null) {
            inOrder(pRootOfTree.left);
        }
        pRootOfTree.left = pre;
        if(pre != null){
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        if (pRootOfTree.right != null) {
            inOrder(pRootOfTree.right);
        }
    }


    public static void main(String[] args) {
        Solution25 x = new Solution25();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        x.Convert(root);
    }
}