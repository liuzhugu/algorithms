//请设计并实现一个能够展开二维向量的迭代器。该迭代器需要支持 next 和 hasNext 两种操作。、 
//
// 示例： 
//
// Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
//
//iterator.next(); // 返回 1
//iterator.next(); // 返回 2
//iterator.next(); // 返回 3
//iterator.hasNext(); // 返回 true
//iterator.hasNext(); // 返回 true
//iterator.next(); // 返回 4
//iterator.hasNext(); // 返回 false
// 
//
// 
//
// 注意： 
//
// 
// 请记得 重置 在 Vector2D 中声明的类变量（静态变量），因为类变量会 在多个测试用例中保持不变，影响判题准确。请 查阅 这里。 
// 你可以假定 next() 的调用总是合法的，即当 next() 被调用时，二维向量总是存在至少一个后续元素。 
// 
//
// 
//
// 进阶： 
//
// 尝试在代码中仅使用 C++ 提供的迭代器 或 Java 提供的迭代器。 
// Related Topics 设计

package leetcode.editor.cn;
//Java：251:展开二维向量 2020/06/05
public class Flatten2dVector{
    public static void main(String[] args) {
        //TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Vector2D {
        int i,j;
        int[][] v;
        int m;
        public Vector2D(int[][] v) {
            this.v = v;
            m = v.length;
            i = 0;
            j = 0;
        }

        public int next() {
            if (! hasNext()) {
                return 0;
            }
            int ans = v[i][j];
            j ++;
            if (j == v[i].length) {
                i ++;
                j = 0;
            }
            //跳过空白
            find();
            return ans;
        }

        public boolean hasNext() {
            if (v == null || v.length == 0) {
                return false;
            }
            //跳过空白
            find();
            //到了结尾
            if (i >= m) {
                return false;
            }
            return true;
        }

        private void find() {
            while (i < m) {
                if (j == v[i].length) {
                    i ++;
                } else {
                    break;
                }
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}