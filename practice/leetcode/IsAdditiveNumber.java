package practice.leetcode;


import java.util.Stack;

/**
 * Created by liuzhugu on 2019/03/07.
 * 306. 累加数
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，
 * 字符串中的其他数都等于它之前两个数相加的和。
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 */
public class IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        //检查边界条件
        if (num.length() < 3){
            return false;
        }
        if (num.length() == 3) {
            if ((Long.parseLong(num.charAt(0) + "") + Long.parseLong(num.charAt(1) + "")
                    == Long.parseLong(num.charAt(2) + ""))) {
                return true;
            }else{
                return false;
            }
        }

        char[] nums = num.toCharArray();
        Stack<Integer> headIndex = new Stack<>();
        int firstIndex = 1,secondIndex = firstIndex + 1,index = 0;
        while (true) {
            if (index == 0 && firstIndex >= ((num.length() + 1) / 2)) {
                //找不到
                return false;
            }
            if (secondIndex >= num.length()) {
                secondIndex = firstIndex;
                firstIndex = index;
                index = headIndex.pop();
                //全部处理完
                long sum = Long.parseLong(num.substring(index,firstIndex)) + Long.parseLong(num.substring(firstIndex,secondIndex));
                int size = (sum + "").length();
                if (sum == Long.parseLong(num.substring(secondIndex,secondIndex + size))) {
                    return true;
                }else {
                    if (headIndex.empty()){
                        //还是在刚开始的地方,因此第一个数增加一位，然后继续试探
                        firstIndex ++;
                        secondIndex = firstIndex + 1;
                        continue;
                    }else {
                        //从头再来
                        while (! headIndex.empty()) {
                            secondIndex = firstIndex;
                            firstIndex = index;
                            index = headIndex.pop();
                        }
                        //设值  开始新一轮
                        firstIndex ++;
                        secondIndex = firstIndex + 1;
                        continue;
                    }
                }
            }
            if (((firstIndex - 1) != index) && nums[index] == '0') {
                if (headIndex.empty()){
                    return false;
                }else {
                    //从头再来
                    while (! headIndex.empty()) {
                        secondIndex = firstIndex;
                        firstIndex = index;
                        index = headIndex.pop();
                    }
                    //设值  开始新一轮
                    firstIndex ++;
                    secondIndex = firstIndex + 1;
                    continue;
                }
            }
            if (((secondIndex - 1) != firstIndex) && nums[firstIndex] == '0') {
                if (headIndex.empty()){
                    //还是在刚开始的地方,因此第二个数增加一位，然后继续试探
                    firstIndex ++;
                    secondIndex = firstIndex + 1;
                    continue;
                }else {
                    //从头再来
                    while (! headIndex.empty()) {
                        secondIndex = firstIndex;
                        firstIndex = index;
                        index = headIndex.pop();
                    }
                    //设值  开始新一轮
                    secondIndex ++;
                    continue;
                }
            }
            if (nums[secondIndex] == '0') {
                if (headIndex.empty()){
                    //还是在刚开始的地方,因此第一个数增加一位，然后继续试探
                    secondIndex ++;
                    continue;
                }else {
                    //从头再来
                    while (! headIndex.empty()) {
                        secondIndex = firstIndex;
                        firstIndex = index;
                        index = headIndex.pop();
                    }
                    //设值  开始新一轮
                    secondIndex ++;
                    continue;
                }
            }
            long sum = Long.parseLong(num.substring(index,firstIndex)) + Long.parseLong(num.substring(firstIndex,secondIndex));
            int size = (sum + "").length();
            //越界
            if ((secondIndex + size) > num.length()) {
                if (headIndex.empty()){
                    //还是在刚开始的地方,因此第一个数增加一位，然后继续试探
                    firstIndex ++;
                    secondIndex = firstIndex + 1;
                    continue;
                }else {
                    //从头再来
                    while (! headIndex.empty()) {
                        secondIndex = firstIndex;
                        firstIndex = index;
                        index = headIndex.pop();
                    }
                    //设值  开始新一轮
                    firstIndex ++;
                    secondIndex = firstIndex + 1;
                    continue;
                }

            }
            if (sum == Long.parseLong(num.substring(secondIndex,secondIndex + size))) {
                //试探成功,整体平移
                headIndex.push(index);
                index = firstIndex;
                firstIndex = secondIndex;
                secondIndex = secondIndex + size;
            }else{
                if (headIndex.empty()){
                    //还是在刚开始的地方,因此第二个数增加一位，然后继续试探
                    secondIndex ++;
                }else {
                    //从头再来
                    while (! headIndex.empty()) {
                        secondIndex = firstIndex;
                        firstIndex = index;
                        index = headIndex.pop();
                    }
                    //设值  开始新一轮
                    secondIndex ++;
                }
            }
        }
    }

//    public boolean isAdditiveNumber(String num) {
//        char[] nums = num.toCharArray();
//        int firstIndex = 1,secondIndex = firstIndex + 1,index = 0;
//        Stack<Integer> headNum = new Stack<>();
//        while (true) {
//            //第一个数位数不能超过(n+1)/2
//            if (index == 0 && firstIndex >= ((num.length() + 1) / 2)) {
//                break;
//            }
//            while (firstIndex < ((num.length() -index + 1) / 2)) {
//                //截取出三个数
//                //如果第一个数是以0开头，直接开始下一轮
//                if (nums[index] =='0') {
//                    if (!headNum.empty()) {
//                        secondIndex = firstIndex;
//                        firstIndex = index;
//                        index = headNum.pop();
//                        break;
//                    }else {
//
//                    }
//                }
//                //如果第二个数是以0开头,那么第二个数试探跳过
//                if (nums[firstIndex] =='0') {
//                    firstIndex++;
//                    secondIndex = firstIndex + 1;
//                    continue;
//                }
//                //如果第二个数是以0开头,那么第二个数的试探跳过
//                if (nums[secondIndex] =='0') {
//                    firstIndex++;
//                    secondIndex = firstIndex + 1;
//                    continue;
//                }
//                //获取和
//                long sum = Long.parseLong(num.substring(index,firstIndex)) + Integer.parseInt(num.substring(firstIndex,secondIndex));
//                int size = (sum+"").length();
//                //越界
//                if ((size + secondIndex) >= num.length()) {
//                    //下一轮,第二个数缩位
//                    firstIndex++;
//                    secondIndex = firstIndex + 1;
//
//                }
//                //判断是否相等,如果相等的话压栈
//                if (sum == Long.parseLong(num.substring(secondIndex,secondIndex + size))) {
//                    headNum.push(index);
//                    index = firstIndex;
//                    firstIndex = secondIndex;
//                }
//            }
//            //栈为空表明之前也没有能回溯的  此时回到开头会满足退出条件
//            if (!headNum.empty()){
//                //回溯
//                secondIndex = firstIndex;
//                firstIndex = index;
//                index = headNum.pop();
//            }
//        }
//        return false;
//    }
}
