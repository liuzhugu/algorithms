//你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。 
//
// 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。 
//
// 示例 1: 
//
// 
//输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
//输出: [20,24]
//解释: 
//列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
//列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
//列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
// 
//
// 注意: 
//
// 
// 给定的列表可能包含重复元素，所以在这里升序表示 >= 。 
// 1 <= k <= 3500 
// -105 <= 元素的值 <= 105 
// 对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。 
// 
// Related Topics 哈希表 双指针 字符串

package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

//Java：632:最小区间  滑动窗口 2020/04/21
public class SmallestRangeCoveringElementsFromKLists{
    public static void main(String[] args) {
        Solution solution = new SmallestRangeCoveringElementsFromKLists().new Solution();
        //TO TEST
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> question = new ArrayList<>();
        list = Arrays.stream(new int[]{4,10,15,24,26}).boxed().collect(Collectors.toList());
        question.add(new ArrayList<>(list));
        list = Arrays.stream(new int[]{0,9,12,20}).boxed().collect(Collectors.toList());
        question.add(new ArrayList<>(list));
        list = Arrays.stream(new int[]{5,18,22,30}).boxed().collect(Collectors.toList());
        question.add(new ArrayList<>(list));
        solution.smallestRange(question);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //合并成一个list  然后在这个list里面滑动窗口
        //不断缩减窗口大小直到窗口最小但里面有每个list的数字
        public int[] smallestRange(List<List<Integer>> nums) {
            if (nums == null || nums.size() == 0) {
                return new int[]{};
            }
            //key为list的index  value为该list在窗口中的数字个数
            int[] map = new int[nums.size()];
            List<Node> list = new ArrayList<>();
            for (int i = 0;i < nums.size();i ++) {
                List<Integer> num = nums.get(i);
                for (int j = 0;j < num.size();j ++) {
                    list.add(new Node(i,num.get(j)));
                }
            }
            //排序
            list.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.val - o2.val;
                }
            });
            int count = 0,j = 0;
            int[] res = new int[2];
            //优先比较len  len相等才比较首尾大小
            int len = Integer.MAX_VALUE;
            for (int i = 0;i < list.size();i ++) {
                //从头构建满足条件的窗口  完成窗口的初始化
                Node node = list.get(i);
                //计数
                map[node.pos] ++;
                if (map[node.pos] == 1) {
                    //该list的元素第一次进入窗口
                    count ++;
                }
                //所有list都有元素在窗口内 满足条件
                if (count == nums.size()) {
                    //窗口左边开始尝试滑动  从而使得窗口变小
                    for (;j < list.size();j ++) {
                        node = list.get(j);
                        //如果这个数字出了窗口  那么就不满足条件了
                        //只有右边有该list的数字进入窗口这个数字才能出窗口
                        if (map[node.pos] == 1) {
                            //此时满足条件且窗口不能再小  可以计算范围了
                             if (list.get(i).val - list.get(j).val < len) {
                                 len = list.get(i).val - list.get(j).val;
                                 res[0] = list.get(j).val;
                                 res[1] = list.get(i).val;
                             }
                             //相等情况不用考虑  因为后面得到的范围 起点肯定大于之前的  所以起点和中点不用更新
                             break;
                        } else {
                            //滑动左边窗口
                            map[node.pos] --;
                        }
                    }
                }
            }
            return res;
        }
    }
    class Node {
        //在哪个list里面
        int pos;
        int val;
        public Node(int pos,int val) {
            this.pos = pos;
            this.val = val;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}