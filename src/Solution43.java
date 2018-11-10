/*
翻转单词顺序
 */
public class Solution43 {
    public String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] a = str.split(" ");
        StringBuffer o = new StringBuffer();
        int i;
        for (i = a.length; i >0;i--){
            o.append(a[i-1]);
            if(i > 1){
                o.append(" ");
            }
        }
        return o.toString();
    }
}
