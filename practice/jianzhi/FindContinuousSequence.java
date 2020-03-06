package practice.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2020/03/06.
 * 面试题57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int size = 2,start = target - (size - 1) * size / 2;
        List<int[]> list = new ArrayList<>();
        while (start > 0) {
            if (start % size == 0) {
                int[] nums = new int[size];
                start = start / size;
                for (int i = start;i < size + start;i ++) {
                    nums[i - start] = i;
                }
                list.add(nums);
            }
            start = target - (size - 1) * size / 2;
            size++;
        }
        int[][] result = new int[list.size()][];
        int index = 0;
        for (int i = list.size() - 1;i >= 0;i --) {
            result[index ++] = list.get(i);
        }
        return result;
    }
}
