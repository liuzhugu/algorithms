package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/09.
 * 面试题37. 序列化二叉树
 *  请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class MinArray {

    //二分法
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        //数组有序时  返回start  因此将mid初始化为start
        int start = 0,end = numbers.length - 1,mid = start;
        while (numbers[start] >= numbers[end]) {
            //start和end紧邻  那么此时start是前面递增数组的最后一位
            //end是后面递增数组的第一位 end即为所求
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            //首尾中都相同  只能采用笨方法  遍历了
            if (numbers[start] == numbers[mid] && numbers[mid] == numbers[end]) {
                return minOrder(numbers,start,end);
            }
            if (numbers[mid] > numbers[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return numbers[mid];
    }
    private int minOrder(int[] numbers,int start,int end) {
        int result = numbers[start];
        for (int i = start;i <= end;i ++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }

//    public int minArray(int[] numbers) {
//        if (numbers == null || numbers.length == 0) {
//            return 0;
//        }
//        int result = numbers[numbers.length - 1],i = numbers.length - 2;
//        while (i >= 0) {
//            if (numbers[i] <= result) {
//                result = numbers[i];
//            } else {
//                break;
//            }
//            i --;
//        }
//        return result;
//    }
}
