package practice.leetcode;

import java.util.*;

/**
 * Created by liuzhugu on 2019/04/17.
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class MaxArea {

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int left = 0,right = height.length - 1;
        int ans = 0;
        //不能相等  相等时面积为0
        while (left < right) {
            ans = Math.max(ans,Math.min(height[left],height[right]) * (right - left));
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return ans;
    }

    //效率过低
//    public int maxArea(int[] height) {
//        Deque<Integer> deque = new LinkedList<>();
//        for (int i = 0;i < height.length;i ++) {
//            while (! deque.isEmpty() && height[deque.getLast()] < height[i]) {
//                deque.removeLast();
//            }
//            deque.add(i);
//        }
//        int ans = 0;
//        for (int i = 0;i < height.length;i ++) {
//            if (i == deque.getFirst()) {
//                deque.removeFirst();
//            }
//            for (int index : deque) {
//                int area = (index - i) * (Math.min(height[i],height[index]));
//                ans = Math.max(ans,area);
//            }
//        }
//        return ans;
//    }
}
