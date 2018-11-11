/*
从扑克牌里随机抽5张牌，判断是不是一个顺子，即这五张牌是不是连续的，2~10为数字本身，大小王为0
可以看成任何数字。
 */
import java.util.Arrays;

public class Solution44 {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length == 0){
            return false;
        }
        Arrays.sort(numbers);
        int sum =0;
        int num0 = 0;
        for(int i = 0; i < numbers.length;i++){
            if(numbers[i] == 0){
                num0++;
            }
            else {
                break;
            }
        }
        for(int i =numbers.length-1; i >=1 && numbers[i-1] !=0; i--){
            int a = numbers[i] - numbers[i-1] - 1;
            if(a <0){
                return false;
            }
            if(sum + a >num0 ){
                return false;
            }
            else {
                sum = sum+a;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] numbers = {1,3,0,0,5};
        Solution44 x = new Solution44();
        System.out.println(x.isContinuous(numbers));
    }
}
