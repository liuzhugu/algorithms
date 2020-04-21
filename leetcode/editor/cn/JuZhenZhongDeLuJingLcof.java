//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "A
//BCCED"
//输出：true
// 
//
// 示例 2： 
//
// 输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 动态规划

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：面试题12:矩阵中的路径  深度优先 2020/04/21
public class JuZhenZhongDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        //TO TEST
//        System.out.println(LeetCodeTest.strDeal("[[\"C\",\"A\",\"A\"],[\"A\",\"A\",\"A\"],[\"B\",\"C\",\"D\"]]\n" +
//                "\"AAB\""));
        solution.exist(new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}}
        ,"AAB");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length,n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            char[] chars = word.toCharArray();
            for (int i = 0;i < m;i ++) {
                for (int j = 0;j < n;j ++) {
                    //首字符相等
                    if (chars[0] == board[i][j]) {
                        if (visit(board,i,j,visited,chars,1)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        private boolean visit(char[][] board,int x,int y,boolean[][] visited,char[] chars,int index) {
            if (index == chars.length) {
                return true;
            }
            int m = board.length,n = board[0].length;
            visited[x][y] = true;
            List<int[]> list = new ArrayList<>();
            if (x > 0 && board[x - 1][y] == chars[index] && visited[x - 1][y] == false) {
                list.add(new int[]{x - 1,y});
            }
            if (y > 0 && board[x][y - 1] == chars[index] && visited[x][y - 1] == false) {
                list.add(new int[]{x,y - 1});
            }
            if (x < m - 1 && board[x + 1][y] == chars[index] && visited[x + 1][y] == false) {
                list.add(new int[]{x + 1,y});
            }
            if (y < n - 1 && board[x][y + 1] == chars[index] && visited[x][y + 1] == false) {
                list.add(new int[]{x,y + 1});
            }
            for (int[] pos : list) {
                if (visit(board,pos[0],pos[1],visited,chars,index + 1)) {
                    return true;
                }
            }
            //复位
            visited[x][y] = false;
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}