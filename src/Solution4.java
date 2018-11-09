/*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution4 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in, int startPre, int endPre, int startIn, int endIn) {
        TreeNode root = new TreeNode(pre[startPre]);
        int i = findX(in, pre[startPre], startIn, endIn);
        int leftNumber = i - startIn;
        int rightNumber = endIn - i;
        if (leftNumber > 0) {
            root.left = reConstructBinaryTree(pre, in, startPre + 1, startPre + leftNumber, startIn, i - 1);
        }
        if (rightNumber > 0) {
            root.right = reConstructBinaryTree(pre, in, startPre + leftNumber + 1, endPre, i + 1, endIn);
        }
        return root;
    }

    public int findX(int[] in, int x, int startIn, int endIn) {
        for (int i = startIn; i <= endIn; i++) {
            if (x == in[i]) {
                return i;
            }
        }
        return -1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
