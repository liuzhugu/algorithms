//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组

package leetcode.editor.cn;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//Java：31:下一个排列  最小队列 2020/04/26
public class NextPermutation{
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        //TO TEST
        solution.nextPermutation(new int[]{1,2,3,3,4,3,2,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            Queue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            queue.add(nums[nums.length - 1]);
            int i;
            for (i = nums.length - 2;i >= 0;i --) {
                if (nums[i] < nums[i + 1]) {
                    queue.add(nums[i]);
                    //找到最小的比nums[i]大的数
                    Queue<Integer> newQueue = new PriorityQueue<>();
                    boolean flag = true;
                    while (! queue.isEmpty()) {
                        if (flag && queue.peek() > nums[i]) {
                            flag = false;
                            nums[i] = queue.poll();
                        } else {
                            newQueue.add(queue.poll());
                        }
                    }
                    queue = newQueue;
                    for (int j = i + 1;j < nums.length;j ++) {
                        nums[j] = queue.poll();
                    }
                    break;
                } else {
                    queue.add(nums[i]);
                }
            }
            if (i < 0) {
                for (int j = 0;j < nums.length;j ++) {
                    nums[j] = queue.poll();
                }
            }
            return;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}