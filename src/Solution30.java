/*
整数中1出现的次数（从1到n整数中1出现的次数）
编程之美题目
 */
public class Solution30 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int result = 0;
        String number = n + "";
        int length = number.length();
        int x = 1;
        for(int i = 1; i <= length; i++ ){
            int a = n / (x*10);
            int b = n % (x);
            int c = number.charAt(length-i) - '0';
            if(c == 0){
                result += (a)*(x);
            }
            else if( c == 1){
                result += (a) *(x) + b+1;
            }
            else {
                result += (a+1) *(x);
            }
            x = x*10;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 13;
        Solution30 solution30 = new Solution30();
        System.out.println(solution30.NumberOf1Between1AndN_Solution(x));
    }
}
