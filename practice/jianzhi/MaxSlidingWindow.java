package practice.jianzhi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by liuzhugu on 2020/03/06.
 * 面试题59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[]{};
        Deque<Integer> deque = new LinkedList<>();
        if (nums.length >= k && k >= 0) {
            result = new int[nums.length - k + 1];
            int index = 1;
            //填充窗口
            for (int i = 0;i < k;i ++) {
                while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                    deque.removeLast();
                }
                deque.add(i);
            }
            result[0] = nums[deque.getFirst()];
            for (int i = k;i < nums.length;i ++) {
                //判断最大的元素是否还在滑窗内
                if (i - deque.getFirst() + 1 > k) deque.removeFirst();
                while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                    deque.removeLast();
                }
                deque.add(i);
                result[index ++] = nums[deque.getFirst()];
            }
        }
        return result;
    }
}
