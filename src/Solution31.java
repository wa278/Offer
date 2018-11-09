import java.util.Arrays;
import java.util.Comparator;

/*
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution31 {
    public String PrintMinNumber(int [] numbers) {
        Integer[] num = new Integer[numbers.length];
        for(int i = 0; i < numbers.length;i++){
            num[i] = new Integer(numbers[i]);
        }
        Arrays.sort(num,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.intValue()+"" +o2.intValue();
                String s2 = o2.intValue() +""+o1.intValue();
                return s1.compareTo(s2);
            }
        });
        String result = "";
        for(int i = 0; i < numbers.length;i++){
            result += num[i].intValue();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] number ={3,32,321};
        Solution31 x = new Solution31();
        String t = x.PrintMinNumber(number);
        System.out.println(t);
    }
}
