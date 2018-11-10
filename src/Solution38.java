/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution38 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return depthOfTree(root) != -1;
    }

    public int depthOfTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = depthOfTree(root.left);
        if(left == -1){
            return -1;
        }
        int right = depthOfTree(root.right);
        if(right == -1){
            return -1;
        }
        return (Math.abs(left-right)<=1)? 1+Math.max(left,right):-1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        Solution38 x = new Solution38();
        System.out.println(x.IsBalanced_Solution(root));
    }
}
