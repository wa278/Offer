/*
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出.
 */
public class Solution42 {
    public String LeftRotateString(String str,int n) {
        if(n > str.length()){
            return "";
        }
        String str1 = str.substring(0,n);
        String str2 = str.substring(n,str.length());
        return str2 + str1;
    }

    public static void main(String[] args) {
        Solution42 x = new Solution42();
        System.out.println(x.LeftRotateString("abcde",2));
    }
}
