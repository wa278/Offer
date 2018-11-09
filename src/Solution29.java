/*
例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
给一个数组，返回它的最大连续子序列的和，子向量的长度至少是1
 */
public class Solution29 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int sum = array[0];
        for(int i = 1; i < array.length; i++){
            sum = Math.max(sum+array[i],array[i]);
            max = Math.max(max,sum);
        }
        return max;
    }
}
