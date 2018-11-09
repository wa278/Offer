/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution22 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence ==null || sequence.length == 0){
            return false;
        }
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }
    public boolean VerifySquenceOfBST(int [] sequence,int a, int b){
        if(a >= b){
            return true;
        }
        int root = sequence[b];
        int k = a;
        while (sequence[k] < root){
            k++;
        }
        int split = k;
        while (k < b-1){
            if(sequence[k] < root){
                return false;
            }
            k++;
        }
        return VerifySquenceOfBST(sequence,a,split-1) && VerifySquenceOfBST(sequence,split,b-1);
    }
}
