/*
输入n个整数，找出其中最小的K个数。
例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution28 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k > input.length){
            return new ArrayList<>();
        }
        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2){
                    return 1;
                }
                else if(o1 > o2){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        for(; i < k ; i++){
            heap.offer(input[i]);
        }
        while (i < input.length){
            heap.offer(input[i]);
            i++;
            heap.poll();
        }
        while (!heap.isEmpty()){
            arrayList.add(heap.poll());
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] x = {4,5,1,6,2,7,3,8};
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.GetLeastNumbers_Solution(x,0));
    }
}
