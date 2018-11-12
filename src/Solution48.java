/*
将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
数值为0或者字符串不是一个合法的数值则返回0。
 */
public class Solution48 {
    public int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        int result = 0;
        boolean flag = true;
        if(str.charAt(0) == '+'){
            str = str.substring(1);
        }
        else if(str.charAt(0) =='-'){
            flag = false;
            str = str.substring(1);
        }
        int k = 1;
        for(int i = 0; i < str.length();i++){
            int num = str.charAt(str.length()-1-i) - '0';
            if(num >9 || num < 0){
                return 0;
            }
            int a = (num) *k;
            result += a;
            k = k * 10;
        }
        return (flag? result : -result);
    }

    public static void main(String[] args) {
        Solution48 x =new Solution48();
        System.out.println(x.StrToInt("123f"));
    }
}
