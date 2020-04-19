package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by liuzhugu on 2019/03/05.
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
public class CoinChange {

    //疯狂裁枝版回溯法
    int minCount = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Integer[] integers = Arrays.stream(coins).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        coins = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        coinChange(coins,0, 0, amount);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
    private void coinChange(int[] coins,int index,int count, int amount) {
        if (amount == 0) {
            minCount = Math.min(count, minCount);
            return;
        }
        if (index == coins.length) {
            return;
        }

        int x = amount / coins[index];
        for (int i = x; i >= 0 && count + i < minCount;i --) {
            coinChange(coins,index + 1, count + i, amount - i * coins[index]);
        }
    }

    //    //超时
//    private int minCoinCount = Integer.MAX_VALUE;
//    public int coinChange(int[] coins, int amount) {
//        if (coins == null || coins.length == 0) {
//            return -1;
//        }
//        if (amount == 0) {
//            return 0;
//        }
//        Arrays.sort(coins);
//        //回溯法
//        coinChange(coins,0,0,amount);
//        return minCoinCount == Integer.MAX_VALUE ? -1 : minCoinCount;
//    }
//    public void coinChange(int[] coins, int coinIndex,int coinCount,int amount) {
//        if (amount < coins[coinIndex]) return;
//        //最多可选多少个该硬币
//        int x = amount / coins[coinIndex];
//        for (int i = x;i >= 0;i --) {
//            if (amount == i * coins[coinIndex]) {
//               if ((coinCount + i) < minCoinCount) {
//                   minCoinCount = coinCount + i;
//               }
//            }
//            if (coinIndex + 1< coins.length) {
//                coinChange(coins,coinIndex + 1,coinCount + i,amount - i * coins[coinIndex]);
//            }
//        }
//    }

//    //效率较低 自上而下
//    public int coinChange(int[] coins, int amount) {
//        if (amount == 0) {
//            return 0;
//        }
//        Arrays.sort(coins);
//        int result = coinChange(coins,amount,new int[amount + 1]);
//        return result == Integer.MAX_VALUE ? -1 : result;
//    }
//
//    public int coinChange(int[] coins, int amount,int[] count) {
//        //不满足条件的终止
//        if (amount < 0) return -1;
//        //递归终止条件
//        if (amount == 0) return 0;
//        if (count[amount] != 0) return count[amount];
//        int min = Integer.MAX_VALUE;
//        for (int i = 0;i < coins.length;i ++) {
//            int dp = coinChange(coins,amount - coins[i],count);
//            if (dp >= 0 && dp < min) {
//                min = dp + 1;
//            }
//        }
//        count[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
//        return count[amount];
//    }


    //效率较低  自下而上
//    public int coinChange(int[] coins, int amount) {
//        Arrays.sort(coins);
//        int[] result = new int[amount + 1];
//        for (int i = 0;i <= amount;i ++) {
//            result[i] = Integer.MAX_VALUE;
//        }
//        for (int i = 0;i < coins.length;i ++) {
//            if (coins[i] <= amount) {
//                result[coins[i]] = 1;
//            }
//        }
//        for (int i = coins[0];i <= amount;i ++) {
//            for (int j = 0;j < coins.length;j ++) {
//                if (coins[j] <= i) {
//                    if (result[i - coins[j]] != Integer.MAX_VALUE) {
//                        result[i] = Math.min(result[i],result[i - coins[j]] + 1);
//                    }
//                }
//            }
//        }
//        return result[amount];
//    }

}
