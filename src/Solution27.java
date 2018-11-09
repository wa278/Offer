/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution27 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int mid = array.length/2;
        int a = 0;
        int b = array.length-1;
        while (a<b){
            int k = partition(array,a,b);
            if(k < mid){
                a = k+1;
            }
            else if(k > mid){
                b = k-1;
            }
            else {
                break;
            }
        }
        int num = array[mid];
        int amount = 0;
        for (int e:array) {
            if(e == num){
                amount++;
            }
        }
        return amount >= array.length/2 +1? num:0;
    }
    public int partition(int[] array, int a,int b){
        int v = array[a];
        int lo = a;
        int hi = b+1;
        while (true){
            while (array[++lo] < v) {
                if(lo == b){
                    break;
                }
            }
            while (array[--hi] > v){
                if(hi == a){
                    break;
                }
            }
            if(hi <= lo){
                exch(array,a,hi);
                break;
            }
            exch(array,lo,hi);
        }
        return hi;

    }
    public void exch(int[] str,int a ,int b){
        int temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1};
        Solution27 x = new Solution27();
        System.out.println(x.MoreThanHalfNum_Solution(array));
    }
}
