/*
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 */
public class Solution10 {
    public int NumberOf1(int n) {
        int result = 0;
        while (n !=0){
            if((n & 1 )== 1){
                result ++;
            }
            n = n >>> 1; //无符号移动 >> << 是有符号移动 负数最高位右移会补1 负数左移最高位不动，第二位移动。
        }
        return result;
    }
}
