package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2020/03/14.
 * 300. 最长上升子序列
 *  给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1;i < nums.length;i ++) {
            int max = 0;
            for (int j = i - 1;j >= 0;j --) {
                if (nums[i] >= nums[j]) {
                    max = Math.max(max,list.get(j));
                }
            }
            list.add(max + 1);
        }
        int max = 0;
        for (int num : list) {
            max = Math.max(max,num);
        }
        return max;
    }
}
