/*
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
  {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution63 {
    Queue<Integer> queue = new LinkedList<>();
    Deque<Integer> max = new LinkedList<>();
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(size > num.length || size <= 0){
            return result;
        }
        for(int i = 0; i < size; i++){
            queue.offer(num[i]);
            add(num[i]);
        }
        result.add(max.getFirst());
        for(int i = size; i < num.length;i++ ){
            int x = queue.poll();
            if(x == max.getFirst()){
                max.removeFirst();
            }
            queue.add(num[i]);
            add(num[i]);
            result.add(max.getFirst());
        }
        return result;
    }
    public void add(int num){
        while (!max.isEmpty() && max.getLast() < num){
            max.removeLast();
        }
        max.addLast(num);
    }
    public static void main(String[] args) {
        Solution63 x = new Solution63();
        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println(x.maxInWindows(num,3));
    }
}
