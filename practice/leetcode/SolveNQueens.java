package practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by liuzhugu on 2019/03/18.
 * 51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] flag = new boolean[n][n];
        int[] indexs = new int[n];
        List<List<String>> result = new ArrayList<>();
        nextStep(flag,0,indexs,result);
        return result;
    }
    private void nextStep(boolean[][] flag,int i,int[] indexs,List<List<String>> result) {
        if (i == flag.length) {
            List<String> stringList = new ArrayList<>();
            for (int m = 0;m < flag.length;m ++) {
                StringBuilder string = new StringBuilder("");
                for (int n = 0;n < flag.length;n ++) {
                    if (n == indexs[m]) {
                        string.append("Q");
                    }else {
                        string.append(".");
                    }
                }
                stringList.add(string.toString());
            }
            result.add(stringList);
            return;
        }
        for (int j = 0;j < flag.length;j ++) {
            if (! flag[i][j]) {
                if (checkRow(flag,i,j) && checkColumn(flag,i,j) && checkOblique(flag,i,j)) {
                    indexs[i] = j;
                    flag[i][j] = true;
                    nextStep(flag,i + 1,indexs,result);
                    flag[i][j] = false;
                }
            }
        }
    }
    private boolean checkRow(boolean[][] flag,int i,int j) {
        for (int n = i;n >= 0;n --) {
            if (flag[n][j]) {
                return false;
            }
        }
        return true;
    }
    private boolean checkColumn(boolean[][] flag,int i,int j) {
        for (int n = j;n >= 0;n --) {
            if (flag[i][n]) {
                return false;
            }
        }
        return true;
    }
    private boolean checkOblique(boolean[][] flag,int i,int j) {
        int m = i,n = j;
        while(m >= 0 && n >= 0){
            if (flag[m --][n --]) {
                return false;
            }
        }
        m = i;
        n = j;
        while(m >= 0 && n < flag.length){
            if (flag[m --][n ++]) {
                return false;
            }
        }
        return true;
    }
}
