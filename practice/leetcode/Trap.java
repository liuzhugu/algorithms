package practice.leetcode;

import java.util.Stack;

/**
 * Created by liuzhugu on 2019/04/04.
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {

    //横向计算雨水高
    //每个柱体依次和左边小于它的柱高求横向雨水高度   单调栈
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0;i < height.length;i ++) {
            //找到单调栈中所有小于该柱高的柱高   分别求所拦截雨水的河水面积
            while (! stack.empty() && height[stack.peek()] <= height[i]) {
                //所拦截雨水的底高
                int buttomIndex = stack.pop();
                //去掉相同的柱高   以便得到雨水的宽
                while (! stack.empty() && height[stack.peek()] == height[buttomIndex]) {
                    stack.pop();
                }
                int topIndex = 0;
                //所拦截雨水的顶高  等于两边柱子中的较小者
                if (! stack.empty()) {
                    topIndex = height[i] > height[stack.peek()] ? stack.peek() : i;
                    //所拦截雨水的宽
                    int width = i - stack.peek() - 1;
                    //所拦截雨水面积
                    ans = ans + (width * (height[topIndex] - height[buttomIndex]));
                }
            }
            //将当前柱加入单调栈
            stack.add(i);
        }
        return ans;
    }


    //竖向计算雨水高
    //两边向最高柱体趋近  每个当前最高柱高在碰到大于等于其的柱高时  中间的柱高与其差值都是所称雨水高度
//    public int trap(int[] height) {
//        if (height == null || height.length == 0) {
//            return 0;
//        }
//        int max = 0,index = 0;
//        for (int i = 0;i < height.length;i ++) {
//            if (height[i] >= max) {
//                max = height[i];
//                index = i;
//            }
//        }
//        int ans = 0,currentMaxHeight = 0;
//        for (int i = 0;i <= index;i ++) {
//            if (height[i] >= currentMaxHeight) {
//                currentMaxHeight = height[i];
//            } else {
//                ans = ans + currentMaxHeight - height[i];
//            }
//        }
//        currentMaxHeight = 0;
//        for (int i = height.length - 1;i >= index;i --) {
//            if (height[i] >= currentMaxHeight) {
//                currentMaxHeight = height[i];
//            } else {
//                ans = ans + currentMaxHeight - height[i];
//            }
//        }
//        return ans;
//    }
}
