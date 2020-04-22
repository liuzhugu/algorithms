//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈
//的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。 
//
// 
//
// 示例 1： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed 是 popped 的排列。 
// 
//
// 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/ 
//

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：面试题31:栈的压入、弹出序列  2020/04/22
public class ZhanDeYaRuDanChuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new ZhanDeYaRuDanChuXuLieLcof().new Solution();
        //TO TEST
        solution.validateStackSequences(new int[]{},new int[]{4,5,3,2,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if ((pushed.length == 0 && popped.length != 0) || (pushed.length != 0 && popped.length == 0)) {
                return false;
            }
            if (pushed.length != 0 && popped.length != 0) {
                //值对应的index
                Map<Integer,Integer> map = new HashMap<>();
                for (int i = 0;i < pushed.length;i ++) {
                    map.put(pushed[i],i);
                }
                for (int i = 0;i < popped.length;i ++) {
                    //将数组的值替换从在原栈中的位置
                    popped[i] = map.get(popped[i]);
                }
                boolean[] pop = new boolean[pushed.length];
                int prePop = -1;
                for (int i = 0;i < popped.length;i ++) {
                    //出栈元素要么是后面进栈(不一定是后面一个 因为可以再进来几个才弹出)的 要么是早它一个的
                    // (如果早它一个的不弹出) 更早之前的也不能弹出
                    if (prePop == -1) {
                        prePop = popped[i];
                        pop[prePop] = true;
                    } else {
                        if (popped[i] < prePop) {
                            //找到prePop前第一个未弹出的
                            int firstNoPop = prePop - 1;
                            while (firstNoPop >= 0 && pop[firstNoPop] == true) {
                                firstNoPop --;
                            }
                            if (popped[i] != firstNoPop) {
                                return false;
                            }
                            prePop = popped[i];
                            pop[prePop] = true;
                        } else {
                            prePop = popped[i];
                            pop[prePop] = true;
                        }
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}