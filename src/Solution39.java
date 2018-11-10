/*
一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
请写程序找出这两个只出现一次的数字。
 */
public class Solution39 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int sum = 0;
        for(int i = 0; i < array.length ; i++){
            sum = sum^array[i];
        }
        int bit = 1;
        while ((sum&1) != 1){
            bit++;
            sum= sum>>1;
        }
        int flag = 1 << (bit-1);
        int a = 0;
        int b = 0;
        for(int i = 0; i < array.length; i++){
            if((array[i] & flag) !=0){
                a = a ^ array[i];
            }
            else {
                b = b ^ array[i];
            }
        }
        num1[0]= a;
        num2[0]= b;

    }

}
