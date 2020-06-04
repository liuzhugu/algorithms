//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 堆 设计

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：295:数据流的中位数 2020/05/29
public class FindMedianFromDataStream{
    public static void main(String[] args) {
        MedianFinder solution = new FindMedianFromDataStream().new MedianFinder();
        //TO TEST
        solution.findMedian();
        solution.addNum(1);
        solution.addNum(2);
        solution.findMedian();
        solution.addNum(3);
        solution.findMedian();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        //最大堆
        PriorityQueue<Integer> max;
        //最小堆
        PriorityQueue<Integer> min;

        /** initialize your data structure here. */
        public MedianFinder() {
            max = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            min = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (max.isEmpty()) {
                max.add(num);
                return;
            }
            if (num > max.peek()) {
                min.add(num);
            } else {
                max.add(num);
            }
            banlance();
        }

        public double findMedian() {
            if (max.size() == 0) {
                return 0;
            }
            if (max.size() == min.size()) {
                return (max.peek() + min.peek()) / 2.0;
            } else if (max.size() > min.size()){
                return max.peek();
            } else {
                return min.peek();
            }
        }

        private void banlance() {
            //那边多 那边弹出
            while (max.size() > min.size() + 1) {
                min.add(max.poll());
            }
            while (min.size() > max.size() + 1) {
                max.add(min.poll());
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}