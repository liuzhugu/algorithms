//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索

package leetcode.editor.cn;

import java.util.*;

//Java：127:单词接龙 2020/05/17
public class WordLadder{
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        //TO TEST
        List<String> list = new ArrayList<>();
        String[] strings = new String[]{"hot","dog"};
        for (String str : strings) {
            list.add(str);
        }
        System.out.println("ans :" + solution.ladderLength("hot","dog",list));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //BFS
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (wordList.isEmpty()) {
                return 0;
            }
            if (! wordList.contains(endWord)) {
                return 0;
            }
            Map<String,List<String>> graph = new HashMap<>();
            wordList.add(beginWord);
            int m = wordList.size();
            Map<String,Boolean> visited = new HashMap<>();
            for (String str : wordList) {
                visited.put(str,false);
                for (int i = 0;i < m;i ++) {
                    if (str.equals(wordList.get(i))) {
                        continue;
                    }
                    //可抵达
                    if (judge(str,wordList.get(i))) {
                        if (! graph.containsKey(str)) {
                            graph.put(str,new ArrayList<>());
                        }
                        graph.get(str).add(wordList.get(i));
                    }
                }
            }
            //广度优先遍历
            List<String> next = new ArrayList<>();
            next.add(beginWord);
            visited.put(beginWord,true);
            int count = 0;
            boolean find = false;
            while (! (next.isEmpty() || find)) {
                List<String> tmp = new ArrayList<>();
                count ++;
                for (String str : next) {
                    if (str.equals(endWord)) {
                        find = true;
                        break;
                    }
                    if(graph.containsKey(str)) {
                        for (String str1 : graph.get(str)) {
                            if (! visited.get(str1)) {
                                visited.put(str1,true);
                                tmp.add(str1);
                            }
                        }
                    }
                }
                next = tmp;
            }
            if (find) {
                return count;
            } else {
                return 0;
            }
        }
//        private void visit(Map<String,List<String>> graph,String current,String end,int index) {
//            //已经访问过了
//            if (visited.get(current)) {
//                return;
//            }
//            //抵达终点
//            if (current.equals(end)) {
//                index ++;
//                ans = Math.min(ans,index);
//                return;
//            }
//            //尽头
//            if (graph.get(current) == null) return;
//            //遍历访问
//            List<String> next = graph.get(current);
//            visited.put(current,true);
//            for (String str : next) {
//                visit(graph,str,end,index + 1);
//            }
//            visited.put(current,false);
//        }
        private boolean judge (String first,String second) {
            int count = 0,index = 0;
            while (index < first.length()) {
                if (first.charAt(index) != second.charAt(index)) {
                    count ++;
                }
                if (count > 1) {
                    return false;
                }
                index ++;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}