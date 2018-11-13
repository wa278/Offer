/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Solution50 {
    public int[] multiply(int[] A) {
        int[] down = new int[A.length];
        int[] up = new int[A.length];
        down[0] = 1;
        up[A.length - 1] = 1;
        for (int i = 1; i < A.length; i++) {
            down[i] = down[i-1] * A[i-1];
            up[A.length-1-i] = up[A.length - i] * A[A.length - i];
        }
        int[] B = new int[A.length];
        for(int i = 0; i < A.length; i++){
            B[i] = up[i] * down[i];
        }
        return B;


    }

    public static void main(String[] args) {

    }
}
