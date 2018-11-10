import java.util.ArrayList;

/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Solution41 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int lo = 0;
        int hi = array.length-1;
        ArrayList<Integer> result = new ArrayList<>();
        while (lo < hi){
            if(array[lo] + array[hi] < sum){
                lo++;
            }
            else if(array[lo] + array[hi] > sum){
                hi--;
            }
            else {
                result.add(array[lo]);
                result.add(array[hi]);
                return result;
            }
        }
        return result;
    }
}
