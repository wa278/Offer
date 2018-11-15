import java.util.Comparator;
import java.util.PriorityQueue;

/*
如何得到一个数据流中的中位数？
如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Solution62 {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1 > o2){
                return -1;
            }
            else if(o1 < o2){
                return 1;
            }
            else {
                return 0;
            }
        }
    });
    public void Insert(Integer num) {
        if(((max.size()+min.size()) & 1 )== 1){
            max.offer(num);
            min.offer(max.poll());
        }
        else {
            min.offer(num);
            max.offer(min.poll());
        }
    }

    public Double GetMedian() {
        if(((max.size() + min.size()) & 1) == 1 ){
            return max.peek() + 0.0;
        }
        else {
            return (max.peek() + min.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        int[] array = {5,2,3,4,1,6,7};
        Solution62 x = new Solution62();
        x.Insert(5);
        x.Insert(2);
        x.Insert(3);
        x.Insert(4);
        x.Insert(1);
        x.Insert(6);
        x.Insert(7);
        System.out.println(x.GetMedian());
    }
}
