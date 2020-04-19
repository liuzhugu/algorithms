package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by liuzhugu on 2019/03/15.
 * 646. 最长数对链
 * 给出n个数对。 在每一个数对中，第一个数字总是比第二个数字小。现在，我们定义一种跟随关系，当且
 * 仅当b<c时,数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链.给定一个对数集合，
 * 找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 */
public class FindLongestChain {

    public int findLongestChain(int[][] pairs){
        int[] rightBorder = new int[pairs.length];
        for (int i = 0;i < pairs.length;i ++) {
            rightBorder[i] = pairs[i][1];
        }
        //按右边界大小排个序
        Arrays.sort(rightBorder);
        boolean[] hasSelect = new boolean[pairs.length];
        Stack<Integer> indexs = new Stack<>();
        for (int i = pairs.length - 1;i >= 0;i --) {
            for (int j = 0;j < pairs.length;j ++) {
                if ((pairs[j][1] == rightBorder[i]) && (hasSelect[j] ==false)) {
                    indexs.add(j);
                    hasSelect[j] = true;
                    break;
                }
            }
        }
        //找到最大最小值,从而得到范围
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for (int i = 0;i < pairs.length;i ++) {
           if (pairs[i][0] < min) {
               min = pairs[i][0];
           }
           if (pairs[i][1] > max) {
               max = pairs[i][1];
           }
        }
        int result = 0;
        boolean[] range = new boolean[max - min + 1];
        while (! indexs.isEmpty()) {
            int index = indexs.pop();
            int i = pairs[index][0];
            for (;i <= pairs[index][1];i ++) {
                if (range[i - min] != false){
                    break;
                }
            }
            if (i > pairs[index][1]) {
                result ++;
                for (int j = pairs[index][0];j <= pairs[index][1];j ++) {
                    range[j - min] = true;
                }
            }
        }
        return result;
    }

    //选错了排序的的贪婪
//    public int findLongestChain(int[][] pairs) {
//        if (pairs == null || pairs.length == 0) {
//            return 0;
//        }
//        int[] lengths = new int[pairs.length];
//        //获取所有间隔长度
//        for (int i = 0;i < pairs.length;i ++) {
//            lengths[i] = pairs[i][1] - pairs[i][0];
//        }
//        //排序
//        Arrays.sort(lengths);
//        boolean[] hasSelect = new boolean[pairs.length];
//        for (int i = 0;i < pairs.length;i ++) {
//            hasSelect[i] = false;
//        }
//        List<Integer> indexs = new ArrayList<>();
//        for (int i = 0;i < pairs.length;i ++) {
//            //找到该间隔所对应的数对
//            for (int j = 0;j < pairs.length;j ++) {
//                if ((lengths[i] == (pairs[j][1] - pairs[j][0])) && hasSelect[j] == false) {
//                    //将间隔从大到小压栈
//                    indexs.add(j);
//                    hasSelect[j] = true;
//                }
//            }
//        }
//        //找出最大最小值
//        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
//        for (int i = 0;i < pairs.length;i ++) {
//            if (pairs[i][0] < min) {
//                min = pairs[i][0];
//            }
//            if (pairs[i][1] > max) {
//                max = pairs[i][1];
//            }
//        }
//        boolean[] range = new boolean[max - min + 1];
//        for (int i = 0;i < (max - min + 1);i ++) {
//            range[i] = false;
//        }
//        int result = 0,lastIndex = 0;
//        //虽然间隔相同,但放入数据不同结果也不同,因此还得回溯
//        return getMax(pairs,indexs,0,range,min,max,result);
//    }
//    private int getMax(int[][] pairs,List<Integer> indexs,int index,boolean[] range,int min,int max,int result) {
//        if (index == indexs.size()) {
//            return result;
//        }
//        int tempMax = result;
//        //判断该值是否能放入
//        int j = pairs[indexs.get(index)][0];
//        for (;j <= pairs[indexs.get(index)][1];j ++) {
//            if (range[j - min] == false) {
//                continue;
//            }else {
//                break;
//            }
//        }
//        boolean selectFlag = false;
//        if (j > pairs[indexs.get(index)][1]) {
//            //选中该数对
//            selectFlag = true;
//            tempMax ++;
//            for (int k = pairs[indexs.get(index)][0];k <= pairs[indexs.get(index)][1];k ++) {
//                range[k - min] = true;
//            }
//        }
//        int pickResult = getMax(pairs,indexs,index +1,range,min,max,tempMax);
//        result = pickResult > result ? pickResult : result;
//        if (selectFlag) {
//            //不选该数对了
//            for (int k = pairs[indexs.get(index)][0];k <= pairs[indexs.get(index)][1];k ++) {
//                range[k - min] = false;
//            }
//            tempMax --;
//        }
//        int noPickResult = getMax(pairs,indexs,index +1,range,min,max,tempMax);
//        result = noPickResult > result ? noPickResult : result;
//
//        return result;
//    }
}
