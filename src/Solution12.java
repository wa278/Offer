/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution12 {
    public void reOrderArray(int [] array) {
        int[] temp = new int[array.length];
        int k = 0;
        for(int i = 0; i<array.length;i++){
            if((array[i] & 1) == 1){
                temp[k++] = array[i];
            }
        }
        for(int i = 0; i<array.length;i++){
            if((array[i] & 1) == 0){
                temp[k++] = array[i];
            }
        }
        for(int i = 0; i < array.length; i++){
            array[i] = temp[i];
        }
    }
}
