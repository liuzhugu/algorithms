//现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。 
//
// 假设，您并不知道其中字母之间的先后顺序。但是，会收到词典中获得一个 不为空的 单词列表。
// 因为是从词典中获得的，所以该单词列表内的单词已经 按这门新语言的字母顺序进行了排序。
//
// 您需要根据这个输入的列表，还原出此语言中已知的字母顺序。 
//
// 
//
// 示例 1： 
//
// 输入:
//[
//  "wrt",
//  "wrf",
//  "er",
//  "ett",
//  "rftt"
//]
//输出: "wertf"
// 
//
// 示例 2： 
//
// 输入:
//[
//  "z",
//  "x"
//]
//输出: "zx"
// 
//
// 示例 3： 
//
// 输入:
//[
//  "z",
//  "x",
//  "z"
//] 
//输出: "" 
//解释: 此顺序是非法的，因此返回 ""。
// 
//
// 
//
// 提示： 
//
// 
// 你可以默认输入的全部都是小写字母 
// 若给定的顺序是不合法的，则返回空字符串即可 
// 若存在多种可能的合法字母顺序，请返回其中任意一种顺序即可 
// 
// Related Topics 图 拓扑排序

package leetcode.editor.cn;

import java.util.*;

//Java：269:火星词典 2020/06/08
public class AlienDictionary{
    public static void main(String[] args) {
        Solution solution = new AlienDictionary().new Solution();
        //TO TEST
        solution.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String alienOrder(String[] words) {
            //构建图
            Map<Character,Set<Character>> map = new HashMap<>();
            for (int i = 0;i < words.length - 1;i ++) {
                String first = words[i],second = words[i + 1];
                int index = 0;
                //找到第一个不同的字符
                while (index < first.length() && index < second.length()) {
                    if (first.charAt(index) != second.charAt(index)) {
                        Set<Character> set = map.getOrDefault(first.charAt(index),new HashSet<>());
                        set.add(second.charAt(index));
                        map.put(first.charAt(index),set);
                        break;
                    }
                    index ++;
                    // 这个就是为了克服abc和ab的问题, 也就是两个字符串前面的部分完全相等(所以在上面的循环结束后j==words[i+1].size()), 但是长的在前面, 短的在后面, 这样是错误的. 直接返回""
                    if(index == words[i+1].length() && words[i].length() > words[i+1].length())
                        return "";
                }
            }

            //创建保存入度的数组  为拓扑排序做准备
            int[] degrees = new int[26];
            Arrays.fill(degrees, -1);
            //注意，不是26字母都在words中出现，
            // 所以出度分为两种情况：没有出现的字母出度为-1，出现了的字母的出度为非负数
            for (String str : words) {
                //将出现过的字符的出度设定为0
                for (char c : str.toCharArray())
                    degrees[c - 'a'] = 0;
            }
            //每个字符的入度
            for (char key : map.keySet()) {
                for (char c : map.get(key)) {
                    degrees[c - 'a'] ++;
                }
            }
            //拓扑排序
            //1.找到没有前驱  即入度为零的节点
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                int i = 0;
                for (;i < 26;i ++) {
                    char key = (char)(i + 'a');
                    //没有前驱
                    if (degrees[i] == 0) {
                        //删除这个节点
                        stringBuilder.append(key);
                        degrees[i] = -1;
                        //将邻接点出度-1
                        if (map.containsKey(key)) {
                            for (char c : map.get(key)) {
                                degrees[c - 'a'] --;
                            }
                        }
                        break;
                    }
                }
                //找不到入度为0的节点了
                if (i == 26) {
                    break;
                }
            }
            for (int i = 0;i < 26;i ++) {
                //发现有节点没处理完 说明出现回环
                if (degrees[i] > 0) {
                    return "";
                }
            }
            return stringBuilder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}