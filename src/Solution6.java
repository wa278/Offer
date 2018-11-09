/*
把一个数组最开始的若干个元素搬到数组的末尾，
我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution6 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int lo = 0;
        int hi = array.length -1;
        int mid = 0;
        while (array[lo] >= array[hi]){
            mid = lo + (hi-lo)/2;
            if(hi - lo == 1){
                mid = hi;
                break;
            }
            if(array[hi] == array[mid] && array[lo] == array[mid]){
                return linearfind(array,lo,hi);
            }
            if(array[mid] >= array[lo]){
                lo = mid;
            }
            else if(array[mid] <= array[hi]){
                hi = mid;
            }
        }
        return array[mid];
    }
    public int linearfind(int[] array,int a, int b){
        int min = array[a];
        for(int i = a; i <=b ; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int array[] = {3,4,5,1,2};
        Solution6 x = new Solution6();
        System.out.println(x.minNumberInRotateArray(array));
    }
}
