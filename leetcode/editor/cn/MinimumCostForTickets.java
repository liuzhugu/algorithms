//在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 36
//5 的整数。 
//
// 火车票有三种不同的销售方式： 
//
// 
// 一张为期一天的通行证售价为 costs[0] 美元； 
// 一张为期七天的通行证售价为 costs[1] 美元； 
// 一张为期三十天的通行证售价为 costs[2] 美元。 
// 
//
// 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第
// 5 天、第 6 天、第 7 天和第 8 天。 
//
// 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。 
//
// 
//
// 示例 1： 
//
// 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
//输出：11
//解释： 
//例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
//在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
//在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
//在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
//你总共花了 $11，并完成了你计划的每一天旅行。
// 
//
// 示例 2： 
//
// 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
//输出：17
//解释：
//例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划： 
//在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
//在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。 
//你总共花了 $17，并完成了你计划的每一天旅行。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= days.length <= 365 
// 1 <= days[i] <= 365 
// days 按顺序严格递增 
// costs.length == 3 
// 1 <= costs[i] <= 1000 
// 
// Related Topics 动态规划

package leetcode.editor.cn;
//Java：983:最低票价 2020/05/06
public class MinimumCostForTickets{
    public static void main(String[] args) {
        Solution solution = new MinimumCostForTickets().new Solution();
        //TO TEST
        solution.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31},new int[]{2,7,15});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            //从后往前
            int minDay = days[0],maxDay = days[days.length - 1];
            int[] dp = new int[maxDay + 31];
            for (int d = maxDay,i = days.length - 1;d >= minDay;d --) {
                //这天要出现
                if (d == days[i]) {
                    //一天和七天 那个便宜
                    dp[d] = Math.min(dp[d + 1] + costs[0],dp[d + 7] + costs[1]);
                    //再和三十天比
                    dp[d] = Math.min(dp[d],dp[d + 30] + costs[2]);
                    i --;
                } else {
                    //不用出门就不用花钱
                    dp[d] = dp[d + 1];
                }
            }
            //返回第一天出发时用的钱
            return dp[minDay];
        }

//        public int mincostTickets(int[] days, int[] costs) {
//            memo = new Integer[days.length];
//            return dp(days,0,costs);
//        }
//        private int[] durations = new int[]{1,7,30};
//        private Integer[] memo;
//        private int dp(int[] days,int i,int[] costs) {
//            if (i >= days.length) {
//                return 0;
//            }
//            //复用结果
//            if (memo[i] != null) {
//                return memo[i];
//            }
//            int j = i;
//            memo[i] = Integer.MAX_VALUE;
//            for (int k = 0;k < 3;k ++) {
//                //直接到通行证用完那天 避免多次递归  从而完成削枝
//                while (j < days.length && days[j] < days[i] + durations[k]) {
//                    j ++;
//                }
//                memo[i] = Math.min(memo[i],dp(days,j,costs) + costs[k]);
//            }
//            return memo[i];
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}