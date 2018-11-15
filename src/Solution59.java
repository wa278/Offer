import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution59 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> floor = new ArrayList<>();
        int line = 1;
        int nextLine = 0;
        if(pRoot == null){
             return result;
        }
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            TreeNode a = queue.poll();
            line--;
            floor.add(a.val);
            if(a.left != null){
                queue.offer(a.left);
                nextLine++;
            }
            if(a.right != null){
                queue.offer(a.right);
                nextLine++;
            }
            if(line == 0){
                result.add(new ArrayList<>(floor));
                floor.clear();
                line = nextLine;
                nextLine = 0;
            }
        }
        return result;
    }
}
