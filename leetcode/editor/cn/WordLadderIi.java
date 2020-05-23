//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
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
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法

package leetcode.editor.cn;

import java.util.*;

//Java：126:单词接龙 II
public class WordLadderIi{
    public static void main(String[] args) {
        Solution solution = new WordLadderIi().new Solution();
        //TO TEST
        List<String> list = new ArrayList<>();
        String[] strings = new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        for (String str : strings) {
            list.add(str);
        }
        System.out.println("ans :" + solution.findLadders("qa","sq",list));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            // 结果集
            List<List<String>> res = new ArrayList<>();
            Set<String> words = new HashSet<>(wordList);
            // 字典中不包含目标单词
            if (!words.contains(endWord)) {
                return res;
            }
            // 存放关系：每个单词可达的下层单词
            Map<String, List<String>> mapTree = new HashMap<>();
            Set<String> begin = new HashSet<>(), end = new HashSet<>();
            begin.add(beginWord);
            end.add(endWord);
            if (buildTree(words, begin, end, mapTree, true)) {
                dfs(res, mapTree, beginWord, endWord, new LinkedList<>());
            }
            return res;
        }

        // 双向BFS，构建每个单词的层级对应关系
        private boolean buildTree(Set<String> words, Set<String> begin, Set<String> end, Map<String, List<String>> mapTree, boolean isFront){
            if (begin.size() == 0) {
                return false;
            }
            // 始终以少的进行探索
            if (begin.size() > end.size()) {
                return buildTree(words, end, begin, mapTree, !isFront);
            }
            // 在已访问的单词集合中去除
            words.removeAll(begin);
            // 标记本层是否已到达目标单词
            boolean isMeet = false;
            // 记录本层所访问的单词
            Set<String> nextLevel = new HashSet<>();
            for (String word : begin) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char temp = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String str = String.valueOf(chars);
                        if (words.contains(str)) {
                            nextLevel.add(str);
                            // 根据访问顺序，添加层级对应关系：始终保持从上层到下层的存储存储关系
                            // true: 从上往下探索：word -> str
                            // false: 从下往上探索：str -> word（查找到的 str 是 word 上层的单词）
                            String key = isFront ? word : str;
                            String nextWord = isFront ? str : word;
                            // 判断是否遇见目标单词
                            if (end.contains(str)) {
                                isMeet = true;
                            }
                            if (!mapTree.containsKey(key)) {
                                mapTree.put(key, new ArrayList<>());
                            }
                            mapTree.get(key).add(nextWord);
                        }
                    }
                    chars[i] = temp;
                }
            }
            if (isMeet) {
                return true;
            }
            return buildTree(words, nextLevel, end, mapTree, isFront);
        }

        // DFS: 组合路径
        private void dfs (List<List<String>> res, Map<String, List<String>> mapTree, String beginWord, String endWord, LinkedList<String> list) {
            list.add(beginWord);
            if (beginWord.equals(endWord)) {
                res.add(new ArrayList<>(list));
                list.removeLast();
                return;
            }
            if (mapTree.containsKey(beginWord)) {
                for (String word : mapTree.get(beginWord)) {
                    dfs(res, mapTree, word, endWord, list);
                }
            }
            list.removeLast();
        }



        //BFS
//        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//            if (wordList.isEmpty()) {
//                return new ArrayList<>();
//            }
//            if (! wordList.contains(endWord)) {
//                return new ArrayList<>();
//            }
//            Map<String,List<String>> graph = new HashMap<>();
//            if (! wordList.contains(beginWord)) {
//                wordList.add(beginWord);
//            }
//            int m = wordList.size();
//            for (String str : wordList) {
//                for (int i = 0;i < m;i ++) {
//                    if (str.equals(wordList.get(i))) {
//                        continue;
//                    }
//                    //可抵达
//                    if (judge(str,wordList.get(i))) {
//                        if (! graph.containsKey(str)) {
//                            graph.put(str,new ArrayList<>());
//                        }
//                        graph.get(str).add(wordList.get(i));
//                    }
//                }
//            }
//            //广度优先遍历
//            List<List<String>> list = new ArrayList<>();
//            List<String> next = new ArrayList<>();
//            next.add(beginWord);
//            Set<String> visited = new HashSet<>();
//            visited.add(beginWord);
//            List<String> list1 = new ArrayList<>(Arrays.asList(beginWord));
//            Queue<List<String>> queue = new LinkedList<>();
//            queue.add(list1);
//            boolean find = false;
//            while (! (queue.isEmpty() || find)) {
//                int size = queue.size();
//                Set<String> subVisited = new HashSet<>();
//                for (int i = 0;i < size;i ++) {
//                    List<String> path = queue.poll();
//                    String last = path.get(path.size() - 1);
//                    if(graph.containsKey(last)) {
//                        for (String str : graph.get(last)) {
//                            //如果下一站是终点
//                            if (str.equals(endWord)) {
//                                List<String> tmpList = new ArrayList<>(path);
//                                tmpList.add(str);
//                                list.add(tmpList);
//                                find = true;
//                            }
//                            if (! visited.contains(str)) {
//                                List<String> tmpList = new ArrayList<>(path);
//                                tmpList.add(str);
//                                queue.add(tmpList);
//                                subVisited.add(str);
//                            }
//                        }
//                    }
//                }
//                visited.addAll(subVisited);
//            }
//            return list;
//        }
//        private boolean judge (String first,String second) {
//            int count = 0,index = 0;
//            while (index < first.length()) {
//                if (first.charAt(index) != second.charAt(index)) {
//                    count ++;
//                }
//                if (count > 1) {
//                    return false;
//                }
//                index ++;
//            }
//            return true;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}