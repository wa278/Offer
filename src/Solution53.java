import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;

/*
请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class Solution53 {
    int[] order = new int[256];
    int k = 0;
    public Solution53 (){
        for(int i = 0 ; i < 256; i++){
            order[i] = -1;
        }
    }

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(order[(int)ch] == -1){
            order[(int)ch] = k;
            k++;
        }
        else if(order[(int)ch] >=0){
            order[(int)ch] = -2;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {   int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < 256; i++){
            if(order[i] >=0) {
                if(order[i] < min){
                    min = order[i];
                    minIndex = i;
                }
            }
        }
        return minIndex == -1? '#' : (char)(minIndex);
    }

    public static void main(String[] args) {
        Solution53 x = new Solution53();
        x.Insert('k');
        System.out.println(x.FirstAppearingOnce());
    }
}
