/*
输入一棵二叉树，求该树的深度。
从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution37 {
    int max = 0;
    int depth = 0;
    public int TreeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        else {
            return 1+Math.max(TreeDepth(root.left),TreeDepth(root.right));
        }
    }
//    public int TreeDepth(TreeNode root) {
//        if(root == null){
//            return max;
//        }
//        preOrder(root);
//        return max;
//    }
//
//    public void preOrder(TreeNode root) {
//        depth++;
//        if(max < depth){
//            max = depth;
//        }
//        if(root.left!= null){
//            preOrder(root.left);
//        }
//        if(root.right != null){
//            preOrder(root.right);
//        }
//        depth--;
//    }
}
