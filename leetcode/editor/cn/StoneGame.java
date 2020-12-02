//亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。 
//
// 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。 
//
// 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
// 
//
// 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。 
//
// 
//
// 示例： 
//
// 输入：[5,3,4,5]
//输出：true
//解释：
//亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
//假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
//如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
//如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
//这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= piles.length <= 500 
// piles.length 是偶数。 
// 1 <= piles[i] <= 500 
// sum(piles) 是奇数。 
// 
// Related Topics 极小化极大 数学 动态规划 
// 👍 196 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：877:石子游戏
public class StoneGame{
    public static void main(String[] args) {
        Solution solution = new StoneGame().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //递归
        public boolean stoneGame(int[] piles) {
            int len = piles.length;
            int[][] memo = new int[len][len];
            for (int i = 0;i < len;i ++) {
                Arrays.fill(memo[i],Integer.MIN_VALUE);
                memo[i][i] = piles[i];
            }
            return stoneGame(piles,0,len - 1,memo) > 0;
        }

        public int stoneGame(int[] piles,int start,int end,int[][] memo) {
            if (start == end) {
                return piles[start];
            }
            //备忘录 避免重复计算
            if (memo[start][end] != Integer.MIN_VALUE) {
                return memo[start][end];
            }
            //有两种选择  因此有两种分支  那么递归得到每种选择的结果  然后传给上层继续递归
            int chooseLeft = piles[start] - stoneGame(piles,start + 1,end,memo);
            int chooseRight = piles[end] - stoneGame(piles,start,end - 1,memo);
            int res = Math.max(chooseLeft,chooseRight);
            memo[start][end] = res;
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}