package leetcode.editor.cn;

import java.util.Arrays;

public class NumMovesStones {
    public int[] numMovesStones(int a, int b, int c) {
        int[] result = new int[2];

        //排序
        int[] arr = new int[]{a,b,c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];

        int leftDis = b - a,rightDis = c - b;
        int minDis = Math.min(leftDis,rightDis);
        if (minDis == 1) {
            if (rightDis == leftDis) {
                result[0] = 0;
            }else {
                result[0] = 1;
            }
        }else if (minDis == 2){
            result[0] = 1;
        }else {
            result[0] = 2;
        }
        result[1] = leftDis + rightDis - 2;
        return result;
    }
}
