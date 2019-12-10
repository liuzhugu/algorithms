package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuzhugu on 2019/11/21.
 * 1218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出arr中所有相邻元素之间的差等于给定
 * difference 的等差子序列，并返回其中最长的等差子序列的长度。
 */
public class LongestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            //找到当前元素的在等差数列中的前一元素其在等差数列中的位置
            int tmp = map.getOrDefault(i - difference,0) + 1;
            //从而得到当前元素在等差数列中的位置
            map.put(i,tmp);
            ans = Math.max(ans,tmp);
        }
        return ans;
    }
}
