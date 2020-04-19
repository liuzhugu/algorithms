package leetcode.editor.cn;

import java.util.*;

/**
 * Created by liuzhugu on 2020/03/28。
 * 820. 单词的压缩编码
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 */
public class MinimumLengthEncoding {
//    //找后缀  因为能合并的单词都是结尾一样的
//    public int minimumLengthEncoding(String[] words) {
//        Set<String> maps = new HashSet<>(Arrays.asList(words));
//        for (String str : words) {
//            //set已经去掉重复的了
//            for (int i = 1;i < str.length();i ++) {
//                maps.remove(str.substring(i));
//            }
//        }
//        int result = 0;
//        for (String str : maps) {
//            result = result + str.length() + 1;
//        }
//        return result;
//    }

    //通过字典树来对找后续进行优化
    public int minimumLengthEncoding(String[] words) {
        //根据长度对字符串排序,因为长度小的可能是长度大的后缀
        List<String> strings = new ArrayList<>(Arrays.asList(words));
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        TrieNode head = new TrieNode();
        //保存叶子节点的深度
        Map<TrieNode,Integer> map = new HashMap<>();
        for (String str : strings) {
            //根据字符串构建字典树
            TrieNode preNode = head;
            for (int i = str.length() - 1;i >= 0;i --) {
                TrieNode node = preNode.get(str.charAt(i));
                //如果该节点后面接有字符  那么该节点不是叶子节点
                map.remove(node);
                //继续处理
                preNode = node;
            }
            //保存叶子节点的深度
            map.put(preNode,str.length());
        }
        //计算总深度
        int result = 0;
        for (int value : map.values()) {
            result = result + value + 1;
        }
        return result;
    }
    //字典树
    class TrieNode {
        //因为大小范围已知 不用list
        TrieNode[] nodes;
        //为0时表示后面没有字符了
        int count;
        public TrieNode () {
            nodes = new TrieNode[26];
            count = 0;
        }
        public TrieNode get(char c) {
            //初始化表示该c接在了字典树上
            if (nodes[c - 'a'] == null) {
                nodes[c - 'a'] = new TrieNode();
                count ++;
            }
            return nodes[c - 'a'];
        }
    }

}


