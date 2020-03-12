package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/12.
 * 面试题39. 数组中出现次数超过一半的数字
 *  数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素
 *
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        //众数和非众数两两抵消   因为众数大于一ba半  所以众数不会被完全抵消
        int result = 0,count = 0;
        for (int num : nums) {
            if (count == 0) {
                result = num;
            }
            if (result == num) {
                count ++;
            } else {
                count --;
            }
        }
        return result;
    }
}
