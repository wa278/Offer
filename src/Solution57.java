import java.util.ArrayList;

/*
请实现一个函数，用来判断一颗二叉树是不是对称的。
注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution57 {
    ArrayList<String> a = new ArrayList<>();
    ArrayList<String> b = new ArrayList<>();

    boolean isSymmetrical(TreeNode pRoot) {
        preOrder(pRoot);
        inPreOrder(pRoot);
        return equal(a, b);
    }
    public boolean equal(ArrayList a, ArrayList b){
        if(a.size() != b.size()){
            return false;
        }
        for(int i =0; i < a.size(); i++){
            if(!a.get(i).equals( b.get(i))){
                return false;
            }
        }
        return true;
    }
    public void preOrder(TreeNode root) {
        if (root == null) {
            a.add("!");
            return;
        }
        a.add(root.val + "");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inPreOrder(TreeNode root) {
        if (root == null) {
            b.add("!");
            return;
        }
        b.add(root.val + "");
        inPreOrder(root.right);
        inPreOrder(root.left);
    }

    public static void main(String[] args) {
        Solution57 x =new Solution57();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);
        x.isSymmetrical(root);
    }
}
