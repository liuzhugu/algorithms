//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：412:Fizz Buzz  2020/06/05
public class FizzBuzz{
    public static void main(String[] args) {
        Solution solution = new FizzBuzz().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> ans = new ArrayList<>();
            String[] strings = new String[]{"Fizz","Buzz","FizzBuzz"};
            for (int i = 1;i <= n;i ++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    ans.add(strings[2]);
                    continue;
                }
                if (i % 3 == 0) {
                    ans.add(strings[0]);
                    continue;
                }
                if (i % 5 == 0) {
                    ans.add(strings[1]);
                    continue;
                }
                ans.add(i + "");
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}