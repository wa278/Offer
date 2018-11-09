/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

 */
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution21 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null){
            return arrayList;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode  x = queue.removeFirst();
            if(x.left !=null){
                queue.addLast(x.left);
            }
            if(x.right != null){
                queue.addLast(x.right);
            }
            arrayList.add(x.val);
        }
        return arrayList;
    }
}
