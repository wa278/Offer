/*
给定一棵二叉搜索树，请找出其中的第k小的结点。
例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class Solution61 {
    int num = 0;
    TreeNode KthNode = null;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        inOrder(pRoot,k);
        return KthNode;

    }
    public void inOrder(TreeNode pRoot, int k){
        if(pRoot != null){
            inOrder(pRoot.left,k);
            num++;
            if(k == num){
                KthNode = pRoot;
            }
            inOrder(pRoot.right,k);
        }
    }
}
