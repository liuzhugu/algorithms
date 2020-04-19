package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2019/03/09.
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票
 */
public class MaxProfit {

    //当前价格作为卖出价格  之前的最小价格作为买入价格
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minProfit = Integer.MAX_VALUE;
        for (int price : prices) {
            if (minProfit != Integer.MAX_VALUE) {
                maxProfit = Math.max(maxProfit,price - minProfit);
            }
            if (price < minProfit) {
                minProfit = price;
            }
        }
        return maxProfit;
    }

    //当前价格作为买入价格  以之后最大的价格作为卖出价格  效率较低
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        //找到每个进入价格之后最高的售出价格下标
//        Deque<Integer> maxSalePrice = new LinkedList<>();
//        for (int i = 0;i < prices.length;i ++) {
//            while (! maxSalePrice.isEmpty() && prices[maxSalePrice.getLast()] < prices[i]) {
//                maxSalePrice.removeLast();
//            }
//            maxSalePrice.add(i);
//        }
//        for (int i = 0;i < prices.length;i ++) {
//            int price = prices[i];
//            if (maxSalePrice.getFirst() <= i) {
//                maxSalePrice.removeFirst();
//            }
//            if (maxSalePrice.isEmpty()) {
//                break;
//            }
//            if ((prices[maxSalePrice.getFirst()] - price) > maxProfit) {
//                maxProfit = prices[maxSalePrice.getFirst()] - price;
//            }
//        }
//        return maxProfit;
//    }
}
