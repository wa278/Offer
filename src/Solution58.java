/*
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution58 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> floor = new ArrayList<>();
        int k = 1;
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
                if((k & 1) == 1)
                    result.add(new ArrayList<>(floor));
                else {
                    ArrayList<Integer> disOrder = new ArrayList<>();
                    for(int i = 0; i < floor.size();i++){
                        disOrder.add(floor.get(floor.size()-i-1));
                    }
                    result.add(disOrder);
                }
                floor.clear();
                line = nextLine;
                nextLine = 0;
                k++;
            }
        }
        return result;
    }
}
