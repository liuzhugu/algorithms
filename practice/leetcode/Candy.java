package practice.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by liuzhugu on 2019/03/17.
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] scores = new int[ratings.length];
        for (int i = 0;i < ratings.length;i ++) {
            //拷贝
            scores[i] = ratings[i];
        }
        Arrays.sort(scores);
        boolean[] hasSelect = new boolean[ratings.length];
        Stack<Integer> indexs = new Stack<>();
        //获取分数从小到大相应孩子的index
        for (int i = scores.length - 1;i >= 0;i --) {
            for (int j = 0;j < scores.length;j ++) {
                if (scores[i] == ratings[j] && hasSelect[j] == false) {
                    indexs.add(j);
                    hasSelect[j] = true;
                }
            }
        }
        //决定相应index的糖果数
        int[] candyNums = new int[ratings.length];
        for (int i = 0;i < ratings.length; i ++) {
            candyNums[i] = Integer.MIN_VALUE;
        }
        while (! indexs.isEmpty()) {
            int index = indexs.pop();
            int leftNum = 1,rightNum = 1;
            //如果右边不为空
            if ((index + 1) < ratings.length){
                if (ratings[index] > ratings[index + 1]) {
                    leftNum = candyNums[index + 1] + 1;
                }
            }
            //如果左边不为空
            if ((index - 1) >= 0){
                if (ratings[index] > ratings[index - 1]) {
                    rightNum = candyNums[index - 1] + 1;
                }
            }
            candyNums[index] = leftNum > rightNum ? leftNum : rightNum;
        }
        //获取糖果总数
        int result = 0;
        for (int i = 0;i < candyNums.length;i ++) {
            result = result + candyNums[i];
        }
        return result;
    }
}
