package practice.jianzhi;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liuzhugu on 2020/03/07.
 * 面试题03. 数组中重复的数字
 *  找出数组中重复的数字。在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 *  数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 *  请找出数组中任意一个重复的数字。
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return 0;
    }
}
