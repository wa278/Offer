/*
统计一个数字在排序数组中出现的次数。
 */
public class Solution36 {
    public int GetNumberOfK(int [] array , int k) {
        int left = leftBinarySearch(array,k,0,array.length-1);
        if(left == -1){
            return 0;
        }
        int right = rightBinarySearch(array,k,0,array.length-1);
        return right-left+1;
    }
    public int leftBinarySearch(int[] array ,int k, int lo, int hi ){
        if(hi < lo){
            return -1;
        }
        int mid = lo +(hi-lo)/2;
        if(array[mid] < k){
            return leftBinarySearch(array,k,mid+1,hi);
        }
        else if(array[mid] > k){
            return leftBinarySearch(array,k,lo,mid-1);
        }
        else {
            if(mid == 0){
                return mid;
            }
            else if(array[mid -1] == array[mid]){
                return leftBinarySearch(array,k,lo,mid-1);
            }
            else {
                return mid;
            }
        }
    }
    public int rightBinarySearch(int[] array ,int k, int lo, int hi ){
        if(hi < lo){
            return -1;
        }
        int mid = lo +(hi-lo)/2;
        if(array[mid] < k){
            return rightBinarySearch(array,k,mid+1,hi);
        }
        else if(array[mid] > k){
            return rightBinarySearch(array,k,lo,mid-1);
        }
        else {
            if(mid == array.length-1){
                return mid;
            }
            else if(array[mid +1] == array[mid]){
                return rightBinarySearch(array,k,mid+1,hi);
            }
            else {
                return mid;
            }
        }
    }
}
