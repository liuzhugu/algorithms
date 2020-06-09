//给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!
//=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。 
//
// 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：["a==b","b!=a"]
//输出：false
//解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
// 
//
// 示例 2： 
//
// 输入：["b==a","a==b"]
//输出：true
//解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
// 
//
// 示例 3： 
//
// 输入：["a==b","b==c","a==c"]
//输出：true
// 
//
// 示例 4： 
//
// 输入：["a==b","b!=c","c==a"]
//输出：false
// 
//
// 示例 5： 
//
// 输入：["c==c","b==d","x!=z"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] 和 equations[i][3] 是小写字母 
// equations[i][1] 要么是 '='，要么是 '!' 
// equations[i][2] 是 '=' 
// 
// Related Topics 并查集 图

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：990:等式方程的可满足性 2020/06/08
public class SatisfiabilityOfEqualityEquations{
    public static void main(String[] args) {
        Solution solution = new SatisfiabilityOfEqualityEquations().new Solution();
        //TO TEST
        solution.equationsPossible(new String[]{"a==b","b!=c","c==a"});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Character,Character> map = new HashMap<>();
        private char find(char c) {
            while (c != map.get(c)) {
                c = map.get(c);
            }
            return c;
        }
        private void build(char x,char y) {
            if (map.containsKey(x) || map.containsKey(y)) {
                if (map.containsKey(x) && ! map.containsKey(y)) {
                    map.put(y,x);
                } else if (! map.containsKey(x) && map.containsKey(y)) {
                    map.put(x,y);
                } else {
                    //两者不相连的话  建立联系
                    if (find(x) != find(y)) {
                        map.put(find(y),x);
                    }
                }
            } else {
                map.put(y,y);
                map.put(x,y);
            }
        }
        public boolean equationsPossible(String[] equations) {
            List<String> notEqual = new ArrayList<>();
            for (String str : equations) {
                //判断是等式还是不等式
                if (str.charAt(1) == '=') {
                    char a = str.charAt(0);
                    char b = str.charAt(3);
                    if (a != b) {
                        build(a,b);
                    }
                } else {
                    notEqual.add(str);
                }
            }
            //判断不相等的
            for (String str : notEqual) {
                char a = str.charAt(0);
                char b = str.charAt(3);
                if (a == b) {
                    return false;
                }
                //两者之一为未确定值  那么一定可以不同
                if (map.containsKey(a) && map.containsKey(b)) {
                    //两者的根节点必须不同
                    if (find(a) == find(b)) {
                        return false;
                    }
                }
            }
            return true;
        }


        //后面的变化不能传给前面 因此不行  还是得并查集
//        public boolean equationsPossible(String[] equations) {
//            Map<Character,Integer> map = new HashMap<>();
//            List<String> notEqual = new ArrayList<>();
//            int index = 1;
//            for (String str : equations) {
//                //判断是等式还是不等式
//                if (str.charAt(1) == '=') {
//                    char a = str.charAt(0);
//                    char b = str.charAt(3);
//                    //如果其中一个有值
//                    if (map.containsKey(a) || map.containsKey(b)) {
//                        //a没值 b有值
//                        if (! map.containsKey(a)) {
//                            map.put(a,map.get(b));
//                        }
//                        //b没值 a有值
//                        else if (! map.containsKey(b)) {
//                            map.put(b,map.get(a));
//                        }
//                        //a和b均有值
//                        else {
//                            if (map.get(a) != map.get(b)) {
//                                return false;
//                            }
//                        }
//                    } else {
//                        //a和b均没值
//                        map.put(a,index);
//                        map.put(b,index);
//                        index ++;
//                    }
//                } else {
//                    notEqual.add(str);
//                }
//            }
//            //判断不相等的
//            for (String str : notEqual) {
//                char a = str.charAt(0);
//                char b = str.charAt(3);
//                if (a == b) {
//                    return false;
//                }
//                //为了两个都没设定值时  仍不相等  因此设定不同默认值
//                int first = map.getOrDefault(a,0);
//                int second = map.getOrDefault(b,-1);
//                if (first == second) {
//                    return false;
//                }
//            }
//            return true;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}