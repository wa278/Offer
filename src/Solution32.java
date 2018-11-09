/*
把只包含质因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含质因子7。
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution32 {
    public int GetUglyNumber_Solution(int index) {
        if(index == 0){
            return 0;
        }
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        int[] unglyNumber = new int[index];
        unglyNumber[0] = 1;
        for(int i = 1; i < index;i++){
            while (unglyNumber[t2] * 2 <= unglyNumber[i-1]){
                t2++;
            }
            while (unglyNumber[t3] * 3 <= unglyNumber[i-1]){
                t3++;
            }
            while (unglyNumber[t5] * 5 <= unglyNumber[i-1]){
                t5++;
            }
            int a = unglyNumber[t2] * 2;
            int b = unglyNumber[t3] * 3;
            int c = unglyNumber[t5] * 5;
            int min = Math.min(Math.min(a,b),c);
            if(min == a){
                unglyNumber[i] = a;
                t2 ++;
            }
            else if(min == b){
                unglyNumber[i] = b;
                t3 ++;
            }
            else {
                unglyNumber[i] = c;
                t5 ++;
            }
        }
        return unglyNumber[index-1];
    }

    public static void main(String[] args) {
        Solution32 x = new Solution32();
        System.out.println(x.GetUglyNumber_Solution(0));
    }
}
