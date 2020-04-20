//由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。 
//
// 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得
//，但不能从 “acbbe” 获得。 
//
// 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S
//1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。 
//
// 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。 
//
// 示例： 
//
// 输入：
//s1 ="acb",n1 = 4
//s2 ="ab",n2 = 2
//
//返回：
//2
// 
// Related Topics 动态规划

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：466:统计重复个数 循环节 2020/04/19
public class CountTheRepetitions{
    public static void main(String[] args) {
        Solution solution = new CountTheRepetitions().new Solution();
        //TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            if (n1 == 0) return 0;
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            int l1 = s1.length();
            int l2 = s2.length();
            //以遍历过的s1和s2的数目
            int count1 = 0;
            int count2 = 0;
            //s2中处理的位置
            int p = 0;
            //便于找到循环节时 能知道循环节有多大
            Map<Integer,int[]> map = new HashMap<>();
            //遍历完n1  找到最大的n2
            while (count1 < n1) {
                //找循环
                for (int i = 0;i < l1;i ++) {
                    if (c1[i] == c2[p]) {
                        p ++;
                        //因为重复  所以到结尾之后又从头开始
                        if (p == l2) {
                            p = 0;
                            count2 ++;
                        }
                    }
                }
                //处理完一个s1了
                count1 ++;
                //每次遍历一个s1 直到发现遍历完之后 跟之前某次处理完时的p相同 那么说明出现循环
                if (! map.containsKey(p)) {
                    map.put(p,new int[]{count1,count2});
                } else {
                    //找到循环节
                    int[] counts = map.get(p);
                    //算出循环节大小
                    int circle1 = count1 - counts[0];
                    int circle2 = count2 - counts[1];
                    //根据循环节  直接跳到结尾
                    count2 = count2 + circle2 * ((n1 - count1) / circle1);
                    count1 = count1 + circle1 * ((n1 - count1) / circle1);
                }
            }
            //因为S2 = s2 * n2
            return count2 / n2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}