//给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。 
//
// 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: [1,1,2,1,1]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: [1,4,6]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
// Related Topics 栈 设计

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//Java：341:扁平化嵌套列表迭代器
public class FlattenNestedListIterator{
    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();

        NestedIterator solution = new FlattenNestedListIterator().new NestedIterator(nestedList);
        System.out.println(solution.hasNext());
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class NestedIterator implements Iterator<Integer> {
        Stack<List<NestedInteger>> stack;
        Stack<Integer> indexs;
        int index;
        List<NestedInteger> curList;
        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            indexs = new Stack<>();
            index = 0;
            curList = nestedList;
        }

        @Override
        public Integer next() {
           if (! hasNext()) {
               return null;
           }
           return curList.get(index ++).getInteger();
        }

        @Override
        public boolean hasNext() {
            //如果到了结尾 那么下一个元素
            while (! stack.isEmpty() && index == curList.size()) {
                index = indexs.pop();
                curList = stack.pop();
            }
            if (index == curList.size()) {
                return false;
            }
            //数字
            if (curList.get(index).isInteger()) {
                return true;
            }
            //列表 继续递归
            else {
                //当栈退出到该层时  说明该层遍历完了 该到下一个了
                indexs.add(index + 1);
                stack.add(curList);
                curList = curList.get(index).getList();
                index = 0;
                //递归
                return hasNext();
            }
        }
    }


     public interface NestedInteger {
         public boolean isInteger();
         public Integer getInteger();
         public List<NestedInteger> getList();
     }
    //leetcode submit region end(Prohibit modification and deletion)

}