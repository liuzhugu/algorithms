//给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则
//返回 -1.0。 
//
// 示例 : 
//给定 a / b = 2.0, b / c = 3.0 
//问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
//返回 [6.0, 0.5, -1.0, 1.0, -1.0 ] 
//
// 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<p
//air<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.siz
//e()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。 
//
// 基于上述例子，输入如下： 
//
// 
//equations(方程式) = [ ["a", "b"], ["b", "c"] ],
//values(方程式结果) = [2.0, 3.0],
//queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] 
//]. 
// 
//
// 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。 
// Related Topics 并查集 图

package leetcode.editor.cn;

import java.util.*;

//Java：399:除法求值 并查集 2020/05/13
public class EvaluateDivision{
    public static void main(String[] args) {
        Solution solution = new EvaluateDivision().new Solution();
        //TO TEST

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private HashMap<String,String> parent=new HashMap<>();
        private HashMap<String,Double> quotient=new HashMap<>();
        private String find(String s) {
            while (s != parent.get(s)) {
                s = parent.get(s);
            }
            return s;
        }
        private boolean build (String x,String y,double value) {
            if (parent.get(x) == null) {
                parent.put(x,x);
                quotient.put(x,1.0);
            }
            if (parent.get(y) == null) {
                parent.put(y,y);
                quotient.put(y,1.0);
            }
            String xRoot = find(x),yRoot = find(y);
            //已在同一棵树上
            if (xRoot.equals(yRoot)) {
                return true;
            }
            //并查集 只建立连接
            parent.put(xRoot,yRoot);
            //在并查集上处于父子关系的节点  在逻辑上并不一定处于父子关系
            //因此另外用map来保存逻辑上的关系

            //因为此时y和x在同一个树上  所以此时两者的值有相对关系
            //根据这相对关系决定重新挂靠之后的倍数关系  这样之后可以沿着路径求倍数关系
            quotient.put(xRoot,value * (cal(y) / cal(x)));
            return true;
        }
        private double cal(String index) {
            //更新值
            double res = quotient.get(index);
            while (parent.get(index) != index) {
                index = parent.get(index);
                res = res * quotient.get(index);
            }
            return res;
        }
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            for (int i = 0;i < equations.size();i ++) {
                List<String> strings = equations.get(i);
                build(strings.get(0),strings.get(1),values[i]);
            }
            //获得返回值
            double[] ans = new double[queries.size()];
            for (int i = 0;i < queries.size();i ++) {
                List<String> strings = queries.get(i);
                String parentStr = strings.get(0);
                String childStr = strings.get(1);
                if (parent.containsKey(parentStr) && parent.containsKey(childStr)) {
                    //两者必须在同一棵树上
                    String xRoot = find(childStr);
                    String yRoot = find(parentStr);
                    if (xRoot.equals(yRoot)) {
                        //重新计算 保证最新
                        double parent = cal(parentStr);
                        double child = cal(childStr);
                        ans[i] = parent / child;
                    } else {
                        ans[i] = -1;
                    }
                } else {
                    ans[i] = -1;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}