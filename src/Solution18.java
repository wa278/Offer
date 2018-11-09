/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
import java.util.ArrayList;

public class Solution18 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = Math.min(matrix.length,matrix[0].length);
        int m = (n+1) /2;
        for(int i =0; i< m;i++){
            for(int j = i; j < matrix[0].length -i;j++){
                arrayList.add(matrix[i][j]);
            }
            for(int j = i+1; j < matrix.length-i;j++){
                arrayList.add(matrix[j][matrix[0].length-1-i]);
            }
            for (int j= matrix[0].length-2-i; j>=0+i && matrix.length-1-i >i;j--){
                arrayList.add(matrix[matrix.length-1-i][j]);
            }
            for (int j = matrix.length-2-i; j >= 1+i && i<matrix[0].length-1-i;j--){
                arrayList.add(matrix[j][i]);
            }
        }
        return arrayList;
    }
}
