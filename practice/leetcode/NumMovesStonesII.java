package practice.leetcode;

import java.util.Arrays;

public class NumMovesStonesII {
    public int[] numMovesStonesII(int[] stones) {
        int[] result = new int[2];
        Arrays.sort(stones);
        int n = stones.length;

        //最大  每次移动了端点之后  端点与其相邻的节点之间的间隔就不能用了
        result[1] = Math.max(stones[n - 1] - stones[1] - n + 2,
                stones[n - 2] - stones[0] - n + 2);

        //最小   n大的滑动窗口  看最多包括几个节点
        int pre = 0,next = 0,min = result[1];
        while (next < stones.length) {
            if ((stones[next] - stones[pre]) > n - 1){
                pre ++;
            }else {
                int cost = n - (next - pre + 1);
                //特殊情况:如果这部分节点刚好连续  那么最小移动2次而不是一次
                if(next - pre + 1 == n- 1 && stones[next] - stones[pre] + 1 == n - 1){
                    cost = 2;
                }
                min = Math.min(min,cost);
                next ++;
            }
        }
        result[0] = min;
        return result;
    }
}
