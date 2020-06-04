//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：212:单词搜索 II 2020/06/01
public class WordSearchIi{
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
        //TO TEST
        //System.out.println(LeetCodeTest.strDeal("[['o','a','a','n'],['e','t','a','e'],['i','h','k','r'],['i','f','l','v']]"));
        solution.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"oathf","oath","pea","eat","rain"});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //深度遍历 + 前缀树 前缀树避免重复判断
        public List<String> findWords(char[][] board, String[] words) {
            if (board == null || board.length == 0) {
                return new ArrayList<>();
            }
            Map<Character,List<int[]>> map = new HashMap<>();
            int m = board.length,n = board[0].length;
            for (int i = 0;i < m;i ++) {
                for (int j = 0;j < n;j ++) {
                    char c = board[i][j];
                    if (! map.containsKey(c)) {
                        map.put(c,new ArrayList<>());
                    }
                    map.get(c).add(new int[]{i,j});
                }
            }
            List<String> ans = new ArrayList<>();
            Trie trie = new Trie();
            for (String str : words) {
                //先从前缀树上找
                if (trie.search(str)) {
                    ans.add(str);
                    continue;
                }
                //DFS
                if (map.containsKey(str.charAt(0))) {
                    List<int[]> starts = map.get(str.charAt(0));
                    for (int[] start : starts) {
                        if (visit(board,start[0],start[1],str.toCharArray(),
                                1,new boolean[m][n])) {
                            ans.add(str);
                            trie.addString(str);
                            break;
                        }
                    }
                }
            }
            return ans;
        }
        private boolean visit(char[][] board,int x,int y,
                              char[] chars,int index,boolean[][] visited) {
            if (chars.length == index) {
                return true;
            }
            visited[x][y] = true;
            //向四向试探
            if (x > 0 && board[x - 1][y] == chars[index] && ! visited[x - 1][y]) {
                if (visit(board,x - 1,y,chars,index + 1,visited)) {
                    return true;
                }
            }
            if (y > 0 && board[x][y - 1] == chars[index] && ! visited[x][y - 1]) {
                if (visit(board,x,y - 1,chars,index + 1,visited)) {
                    return true;
                }
            }
            if (x < board.length - 1 && board[x + 1][y] == chars[index] && ! visited[x + 1][y]) {
                if (visit(board,x + 1,y,chars,index + 1,visited)) {
                    return true;
                }
            }
            if (y < board[0].length - 1 && board[x][y + 1] == chars[index] && ! visited[x][y + 1]) {
                if (visit(board,x,y + 1,chars,index + 1,visited)) {
                    return true;
                }
            }
            visited[x][y] = false;
            return false;
        }
        class Trie {
            TrieNode[] dictionary = new TrieNode[26];

            public void addString(String str) {
                TrieNode[] pre = dictionary;
                for (char c : str.toCharArray()) {
                    if (pre[c - 'a'] == null) {
                        pre[c - 'a'] = new TrieNode();
                    }
                    TrieNode current = pre[c - 'a'];
                    pre = current.child;
                }
            }

            public boolean search(String str) {
                if (str == null || str.length() == 0) {
                    return false;
                }
                if (dictionary[str.charAt(0) - 'a'] == null) {
                    return false;
                }
                return judge(dictionary[str.charAt(0) - 'a'],str.toCharArray(),1);
            }

            private boolean judge (TrieNode root,char[] chars,int index) {
                if (chars.length == index) {
                    return true;
                }
                if (root.child[chars[index] - 'a'] == null) {
                    return false;
                }
                return judge(root.child[chars[index] - 'a'],chars,index + 1);
            }

            class TrieNode {
                TrieNode[] child;
                public TrieNode () {
                    child = new TrieNode[26];
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}