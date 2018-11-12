/*
在一个长度为n的数组里的所有数字都在0到n-1的范围内。
数组中某些数字是重复的，但不知道有几个数字是重复的。
也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Solution49 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        int i = 0;
        while (i < length){
            if(numbers[i] != i){
                if(numbers[numbers[i]] == numbers[i] ){
                    duplication[0] = numbers[i];
                    return true;
                }
                else
                    exch(numbers,numbers[i],i);
            }
            else {
                i++;
            }
        }
        return false;

    }
    public void exch(int[] numbers, int a ,int b ){
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    public static void main(String[] args) {
        Solution49 x = new Solution49();
        int[] numbers = {0};
        int[] d = new int[1];
        System.out.println(x.duplicate(numbers, 1, d));
        System.out.println(d[0]);
    }
}
