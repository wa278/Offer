import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Solution26 {
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() ==0){
            return new ArrayList<String>();
        }
        char[] string = str.toCharArray();
        ArrayList<String> result= new ArrayList<>();
        HashSet<String> res = new HashSet<>();
        permutation(string,0,res);
        for (String e: res) {
            result.add(e);
        }
        Collections.sort(result);
        return result;
    }
    public void permutation(char[] str,int i,HashSet<String> res){
        for (int j = i; j < str.length;j++){
            exch(str,i,j);
            res.add(new String(str));
            permutation(str,i+1,res);
            exch(str,i,j);
        }
    }
    public void exch(char[] str,int a ,int b){
        char temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }
}
