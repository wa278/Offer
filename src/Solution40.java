import java.util.ArrayList;

/*
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution40 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int a = 1;
        int b = 1;
        int num = 1;
        ArrayList<ArrayList<Integer>> result =new ArrayList<>();
        while (a < sum/2){
            if(num < sum){
                b++;
                num = num+b;
            }
            else if(num > sum){
                num = num -a;
                a++;
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = a; i <= b; i++){
                    list.add(i);
                }
                result.add(list);
                b++;
                num = num+b;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution40 x = new Solution40();
        System.out.println(x.FindContinuousSequence(100));
    }
}
