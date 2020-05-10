//删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。 
//
// 说明: 输入可能包含了除 ( 和 ) 以外的字符。 
//
// 示例 1: 
//
// 输入: "()())()"
//输出: ["()()()", "(())()"]
// 
//
// 示例 2: 
//
// 输入: "(a)())()"
//输出: ["(a)()()", "(a())()"]
// 
//
// 示例 3: 
//
// 输入: ")("
//输出: [""] 
// Related Topics 深度优先搜索 广度优先搜索

package leetcode.editor.cn;

import java.util.*;

//Java：301:删除无效的括号 2020/05/08
public class RemoveInvalidParentheses{
    public static void main(String[] args) {
        Solution solution = new RemoveInvalidParentheses().new Solution();
        //TO TEST
        solution.removeInvalidParentheses("()())()");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            if (s == null || s.length() == 0) {
                List<String> tmp = new ArrayList<>();
                tmp.add("");
                return tmp;
            }
            Set<String> strings = new HashSet<>();
            visit(s.toCharArray(),0,new Stack<>(),new ArrayList<>(),strings);
            List<String> ans = new ArrayList<>(strings);
            return ans;
        }
        //递归
        private int max = Integer.MIN_VALUE;
        private void visit(char[] chars, int index, Stack<Character> stack,List<Character> list, Set<String> ans) {
            //削枝  假设剩下的全选 还是不满足
            if (list.size() + (chars.length - index) < max) {
                return;
            }
            if (index == chars.length) {
                if (! stack.isEmpty()) {
                    return;
                }
                if (list.size() < max) {
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : list) {
                    stringBuilder.append(c);
                }
                if (list.size() > max) {
                    max = Math.max(max,list.size());
                    ans.clear();
                }
                ans.add(stringBuilder.toString());
                return;
            }
            //因为要竟可能长 所以 优先选择该字符
            boolean add = false;
            boolean pop = false;
            boolean push = false;
            //该字符为 )
            if (chars[index] == ')' && !stack.isEmpty() && stack.peek().equals('(')) {
                stack.pop();
                pop = true;
                list.add(chars[index]);
                add = true;
                visit(chars,index + 1,stack,list,ans);
            }
            //该字符为 (
            if (chars[index] == '(') {
                stack.add('(');
                push = true;
                list.add(chars[index]);
                add = true;
                visit(chars,index + 1,stack,list,ans);
            }
            //该字符为其他字符
            if (chars[index] != '(' && chars[index] != ')') {
                list.add(chars[index]);
                add = true;
                visit(chars,index + 1,stack,list,ans);
            }
            //还原现场 加了就得去掉  去掉就得加回来
            if (add) {
                //弹出来  就得加回去
                if (pop) {
                    stack.add('(');
                }
                //加了就得去掉
                if (push) {
                    stack.pop();
                }
                //加了就得去掉
                list.remove(list.size() - 1);
            }
            visit(chars,index + 1,stack,list,ans);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}