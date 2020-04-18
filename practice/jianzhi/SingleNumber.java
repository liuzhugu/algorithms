package practice.jianzhi;

/**
 * Created by liuzhugu on 2019/04/18.
 * 面试题56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class SingleNumber {
    //如果该数字某一位为1  那么所有数的该位加起来 1的个数要么是3n + 1 要么是1
    //同样如果是0的话  那么0的个数要么是3n + 1要么是1
    public int singleNumber(int[] nums) {
        //得到结果的每一位  然后汇总起来就是结果
        int ans = 0;
        int i = 1;
        for (int index = 0;index < 31;index ++) {
            //1的个数
            int count = 0;
            for (int num : nums) {
                //判断第index位是否为1
                if ((i & num) != 0) {
                    count ++;
                }
            }
            //该位为1
            if (count % 3 == 1) {
                ans = ans + i;
            }
            i = i << 1;
        }
        return ans;
    }
}
