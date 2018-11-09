import java.util.ArrayList;
import java.util.LinkedList;

/*
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(注意: 在返回值的list中，数组长度大的数组靠前)

 */
public class Solution23 {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    LinkedList<Integer> linkedList = new LinkedList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null && target == 0){
            return result;
        }
        find(root,target);
        return result;
    }
    public void find(TreeNode root,int target){
        linkedList.addLast(root.val);
        if(root.left == null && root.right == null && root.val == target){
            ArrayList<Integer> x = new ArrayList<>(linkedList);
            result.add(x);
        }
        if(root.left != null){
            find(root.left,target - root.val);
        }
        if(root.right != null){
            find(root.right,target- root.val);
        }
        linkedList.removeLast();
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        a.left = new TreeNode(5);
        a.right = new TreeNode(12);
        a.left.left = new TreeNode(4);
        a.left.right= new TreeNode(7);
        Solution23 x = new Solution23();
        x.FindPath(a,22);
    }
}
