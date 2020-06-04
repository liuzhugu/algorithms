//设计一个支持以下两种操作的数据结构： 
//
// void addWord(word)
//bool search(word)
// 
//
// search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。 
//
// 示例: 
//
// addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
// 
//
// 说明: 
//
// 你可以假设所有单词都是由小写字母 a-z 组成的。 
// Related Topics 设计 字典树 回溯算法

package leetcode.editor.cn;
//Java：211:添加与搜索单词 - 数据结构设计 字典树 2020/06/01
public class AddAndSearchWordDataStructureDesign{
    public static void main(String[] args) {
        WordDictionary solution = new AddAndSearchWordDataStructureDesign().new WordDictionary();
        //TO TEST
        solution.addWord("at");
        solution.addWord("and");
        solution.addWord("an");
        solution.addWord("add");
        System.out.println(solution.search("a"));
        System.out.println(solution.search(".at"));
        solution.addWord("bat");
        System.out.println(solution.search(".at"));
        System.out.println(solution.search("an."));
        System.out.println(solution.search("a.d."));
        System.out.println(solution.search("b."));
        System.out.println(solution.search("a.d"));
        System.out.println(solution.search("."));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {
        DictionaryTreeNode dictionary;
        public WordDictionary() {
            dictionary = new DictionaryTreeNode();
        }

        public void addWord(String word) {
            //从字典开始
            DictionaryTreeNode pre = dictionary;
            char[] chars = word.toCharArray();
            for (int i = 0;i < chars.length;i ++) {
                if (pre.list[chars[i] - 'a'] == null) {
                    pre.list[chars[i] - 'a'] = new DictionaryTreeNode();
                }
                DictionaryTreeNode current = pre.list[chars[i] - 'a'];
                //到了结尾  标记一下
                if (i == chars.length - 1) {
                    current.isEnd = true;
                }
                pre = current;
            }
        }


        public boolean search(String word) {
            return judge(word.toCharArray(),0,dictionary);
        }

        private boolean judge(char[] chars,int index,DictionaryTreeNode root) {
            //到了结尾
            if (index == chars.length) {
                //而且这里也是相应的结尾
                return root.isEnd;
            }
            if (root == null) {
                return false;
            }
            if (chars[index] == '.') {
                //遍历所有可能
                for (int i = 0;i < 26;i ++) {
                    if (root.list[i] != null && judge(chars,index + 1,root.list[i])) {
                        return true;
                    }
                }
                //遍历所有情况都不行
                return false;
            } else {
                if (root.list[chars[index] - 'a'] != null) {
                    //继续
                    return judge(chars,index + 1,root.list[chars[index] - 'a']);
                } else {
                    //没有相应后续
                    return false;
                }
            }
        }

        class DictionaryTreeNode {
            boolean isEnd = false;
            DictionaryTreeNode[] list;
            public DictionaryTreeNode() {
                list = new DictionaryTreeNode[26];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}