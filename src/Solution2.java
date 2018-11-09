/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        StringBuffer s = new StringBuffer();
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i)==' '){
                s.append("%20");
            }
            else {
                s.append(str.charAt(i));
            }
        }
        return s.toString();
    }
}