package practice.jianzhi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by liuzhugu on 2019/04/19.
 * 面试题41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 例如，[2,3,4] 的中位数是 3  [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 *      void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 *      double findMedian() - 返回目前所有元素的中位数。
 */
public class MedianFinder {
    //最小堆
    private PriorityQueue<Integer> minHeap;
    //最大堆
    private PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        //在左半部分
        if (num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        //平衡两边数目
        if (minHeap.size() != maxHeap.size()) {
            //左边多
            if (maxHeap.size() > minHeap.size() + 1) {
                //左边移到右边
                while (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                }
            }
            //右边多
            if (minHeap.size() > maxHeap.size() + 1) {
                //右边移到左边
                while (minHeap.size() > maxHeap.size() + 1) {
                    maxHeap.add(minHeap.poll());
                }
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            return 0;
        }
        if (maxHeap.size() == minHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }
}
