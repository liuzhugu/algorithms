package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Change {
    //自底向上
    public int change(int amount, int[] coins) {
        int[] results = new int[amount + 1];
        results[0] = 1;
        for (int coin : coins) {
            for (int i = coin;i < amount + 1;i ++) {
                //遍历coin  dp[i] = dp[i] + dp[i - coin]
                //左边的dp[i]表示选择当前coin的总结果
                //等于 右边的dp[i]是之前coin的结果 + dp[i - coin]表示选择了coin时的情况
                results[i] = results[i] + results[i - coin];
            }
        }
        return results[amount];
    }

    //超时  自顶向下  重复计算的结果太多次
//    public int change(int amount, int[] coins) {
//        if (amount == 0){
//            return 1;
//        }
//        List<Integer> list = new ArrayList<>();
//        change(amount,0,coins,list);
//        return list.size();
//    }
//    public void change(int overage,int index, int[] coins,List<Integer> list) {
//        if (index == coins.length) {
//            return;
//        }
//        while (overage > 0) {
//            change(overage,index + 1,coins,list);
//            overage = overage - coins[index];
//
//        }
//        if (overage == 0) {
//            list.add(0);
//        }
//    }
}
