//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 示例: 
//
// 
//s = "3[a]2[bc]", 返回 "aaabcbc".
//s = "3[a2[c]]", 返回 "accaccacc".
//s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
// 
// Related Topics 栈 深度优先搜索

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

//Java：394:字符串解码
public class DecodeString{
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        //TO TEST
        System.out.println(solution.decodeString("3[a]ef2[2[b]4[F]c]"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //顺序
        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            int multi = 0;
            LinkedList<Integer> stackMulti = new LinkedList<>();
            LinkedList<String> stackRes = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c == '[') {
                    //保存状态
                    stackMulti.add(multi);
                    //保存之前结果 便于[]内的处理完之后与该字符串连起来
                    stackRes.add(res.toString());
                    //复位
                    multi = 0;
                    res = new StringBuilder();
                } else if (c == ']') {
                    //开始处理这个[]之内的东西
                    StringBuilder tmp = new StringBuilder();
                    //取重复次数
                    int curMulti = stackMulti.removeLast();
                    //拼接字符串
                    for (int i = 0;i < curMulti;i ++) {
                        tmp.append(res);
                    }

                    //将这一块的结果和前面的串起来
                    res = new StringBuilder(stackRes.removeLast() + tmp);

                } else if (c >= '0' && c <= '9') {
                    multi = multi * 10 + c - '0';
                } else {
                    res.append(c);
                }
            }
            return res.toString();
        }

        //逆序
//        public String decodeString(String s) {
//            if (s == null || s.length() == 0) {
//                return "";
//            }
//            Stack<Character> stack = new Stack<>();
//            for (int i = 0;i < s.length();i ++) {
//                stack.add(s.charAt(i));
//            }
//            String pre = "";
//            while (! stack.isEmpty()) {
//                pre = visit(stack) + pre;
//            }
//            return pre;
//        }
//        //递归处理
//        private String visit(Stack<Character> stack) {
//            String str = "";
//            //弹出']'
//            if (! stack.isEmpty() && stack.peek().equals(']')) {
//                stack.pop();
//            }
//            while (!stack.isEmpty() && ! stack.peek().equals('[')) {
//                StringBuilder stringBuilder = new StringBuilder();
//                //如果还有 ']'  递归处理
//                String next = "";
//                if (! stack.isEmpty() && stack.peek().equals(']')) {
//                    next = visit(stack);
//                }
//                //找字符
//                while (! stack.isEmpty() && ((stack.peek() >= 'a' && stack.peek() <= 'z')
//                        || (stack.peek() >= 'A' && stack.peek() <= 'Z'))) {
//                    stringBuilder.append(stack.pop());
//                }
//                //反转
//                stringBuilder.reverse();
//                str = stringBuilder.toString() + next + str;
//            }
//            //弹 '['
//            if (! stack.isEmpty() && stack.peek().equals('[')) {
//                stack.pop();
//            }
//            //弹数字
//            int num = 0;
//            int index = 0;
//            while (! stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
//                num = (stack.pop() - '0') * (int)Math.pow(10,index) + num;
//                index ++;
//            }
//            if (num == 0) {
//                num = 1;
//            }
//            StringBuilder ans = new StringBuilder();
//            for (int i = 0;i < num;i ++) {
//                ans.append(str);
//            }
//            return ans.toString();
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}