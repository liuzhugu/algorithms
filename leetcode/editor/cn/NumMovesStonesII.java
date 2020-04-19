package leetcode.editor.cn;

import java.util.Arrays;
/**
 * Created by liuzhugu on 2019/12/26.
 * 1040. 移动石子直到连续 II
 * 在一个长度无限的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，
 * 那么该石子被称作端点石子。每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，
 * 使得该石子不再是一颗端点石子。值得注意的是，如果石子像 stones = [1,2,5] 这样，
 * 你将无法移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3），
 * 该石子都仍然会是端点石子。当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：
 * answer = [minimum_moves, maximum_moves] 。
 */
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
