package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/06.
 * 面试题56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class SingleNumbers {

    //更高效的方法
    public int[] singleNumbers(int[] nums) {
        int temp = 0;
        //因为相同的数异或为0  所以两两出去的数字都消去了  最后得到的结果是只出现一次的两个数字异或的结果
        for (int num : nums) {
            temp = temp ^ num;
        }
        //获得lowbit(单取该数字二进制中为1的最低位对应的数字)
        int mask = temp & (- temp);
        int[] result = new int[2];
        for (int num : nums) {
            //相同数字与mask与的结果相同  被分到同一组  之后异或被消去 最后只剩下独特数字
            //两个独特数字在mask位不同  与的结果也不同  因此被分到不同组去
            //不同组的数字异或之后就是该组的独特数据
            if ((num & mask) == 0) {
                result[0] = result[0] ^ num;
            } else {
                result[1] = result[1] ^ num;
            }
        }
        return result;
    }

//    public int[] singleNumbers(int[] nums) {
//        int[] result = new int[]{};
//        if (nums == null || nums.length == 0) {
//            return result;
//        }
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0;i < nums.length;i ++) {
//            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
//        }
//        List<Integer> list = new ArrayList<>();
//        for (int key : map.keySet()) {
//            if (map.get(key) == 1) {
//                list.add(key);
//            }
//        }
//        int index = 0;
//        result = new int[list.size()];
//        for (int i : list) {
//            result[index ++] = i;
//        }
//        return result;
//    }
}
