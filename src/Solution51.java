/*
请实现一个函数用来匹配包括'.'和'*'的正则表达式。
模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution51 {
    public boolean match(char[] str, char[] pattern) {
        return match(str, pattern, 0, 0);
    }

    public boolean match(char[] str, char[] pattern, int i, int j) {
        if (i >= str.length && j >= pattern.length) {
            return true;
        } else if (i < str.length && j < pattern.length) {
            if (j < pattern.length - 1 && pattern[j + 1] == '*') {
                if (pattern[j] == '.' || str[i] == pattern[j]) {
                    return match(str, pattern, i + 1, j) || match(str, pattern, i, j + 2);
                } else {
                    return match(str, pattern, i, j + 2);
                }
            }
            else {
                if (str[i] == pattern[j] || pattern[j] == '.') {
                    return match(str, pattern, i + 1, j + 1);
                } else {
                    return false;
                }
            }
        }
        else if(j < pattern.length - 1 && pattern[j + 1] == '*'){
            return match(str,pattern,i,j+2);
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution51 x = new Solution51();
        System.out.println(x.match("".toCharArray(), ".*".toCharArray()));
    }
}
