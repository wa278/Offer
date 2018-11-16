import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Solution60 {
    public String Serialize(TreeNode root) {
        if (root != null) {
            return "" + root.val + " " + Serialize(root.left) + Serialize(root.right);
        } else {
            return "& ";
        }
    }

    public TreeNode Deserialize(List<String> list) {
        if(list.get(0).equals("&") ){
            list.remove(0);
            return null;
        }
        else {
            TreeNode node = new TreeNode(Integer.parseInt(list.remove(0)));
            node.left = Deserialize(list);
            node.right = Deserialize(list);
            return node;
        }
    }

    public TreeNode Deserialize(String str) {

        String[] tree = str.split(" ");
        List<String> list = new LinkedList<String>(Arrays.asList(tree));
        return Deserialize(list);
    }

    public static void main(String[] args) {
        Solution60 x = new Solution60();
        String p = "8 6 & & 10 & & ";
        TreeNode a = x.Deserialize(p);
        int k = 0;
    }
}
