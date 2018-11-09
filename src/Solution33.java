import java.util.HashMap;

/*
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Solution33 {
    public int FirstNotRepeatingChar(String str) {
        int[] record = new int[str.length()];
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < str.length();i++){
            if(!hashMap.containsKey(str.charAt(i))){
                hashMap.put(str.charAt(i),i);
                record[i] = 1;
            }
            else {
                int j = hashMap.get(str.charAt(i));
                record[j]++;
            }
        }
        for(int i = 0; i < str.length(); i++){
            if(record[i] == 1){
                return i;
            }
        }
        return -1;
    }
}
