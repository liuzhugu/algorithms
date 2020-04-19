package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2019/12/15.
 * 1105. 填充书架
 * 附近的家居城促销，你买回了一直心仪的可调节书架，打算把自己的书都整理到新的书架上。
 * 你把要摆放的书 books 都整理好，叠成一摞：从上往下，第 i 本书的厚度为 books[i][0]，
 * 高度为 books[i][1]。按顺序 将这些书摆放到总宽度为 shelf_width 的书架上。
 * 先选几本书放在书架上（它们的厚度之和小于等于书架的宽度 shelf_width），然后再建一层书架。
 * 重复这个过程，直到把所有的书都放在书架上。需要注意的是，在上述过程的每个步骤中，
 * 摆放书的顺序与你整理好的顺序相同。 例如，如果这里有5本书，那么可能的一种摆放情况是：
 * 第一和第二本书放在第一层书架上，第三本书放在第二层书架上，第四和第五本书放在最后一层书架上。
 * 每一层所摆放的书的最大高度就是这一层书架的层高，书架整体的高度为各层高之和。以这种方式布置书架，
 * 返回书架整体可能的最小高度
 */
public class MinHeightShelves {
    //动态规划
    //1.自底向上，逐步切分
    //2.在当前问题规模上求解问题
    //3.在遍历过程中获取所有情况的值从而比较得到最优解
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n + 1];
        //遍历求解，划分不同问题规模
        dp[0] = 0;
        for (int i = 0;i < books.length;i ++) {
            //依次从前一层取书下来得到新层高,然后比较
            int curHigh = 0;
            int curWidth = 0;
            int tmp = 1000000 * (n + 1);
            for (int j = i;j >= 0;j --) {
                if (curWidth + books[j][0] <= shelf_width) {
                    curWidth = curWidth + books[j][0];
                    curHigh = Math.max(curHigh,books[j][1]);
                    tmp = Math.min(tmp,curHigh + dp[j]);
                }else {
                    break;
                }
            }
            dp[i + 1] = tmp;
        }
        return dp[books.length];
    }
}
