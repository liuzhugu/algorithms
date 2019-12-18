package practice.leetcode;

class TrieNode {
    private final int R = 26;

    //因为字符已知,因此创建数组方便查找  而不是使用list
    TrieNode[] links;

    boolean isEnd;

    public TrieNode() {
        links = new TrieNode[26];
    }

    public boolean containKey(char c) {
        return links[c - 'a'] != null;
    }
    public void put(char c,TrieNode node) {
        links[c - 'a'] = node;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0;i < word.length();i ++) {
            char c = word.charAt(i);
            if (!node.containKey(c)) {
                //如果没有就新建,否则取已有的
                node.put(c,new TrieNode());
            }
            //递进
            node = node.get(c);
        }
        //设置结尾
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0;i < word.length();i ++) {
            if (node.containKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            }else {
                return false;
            }
        }
        if (node.isEnd) {
            return true;
        }else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0;i < prefix.length();i ++) {
            if (node.containKey(prefix.charAt(i))) {
                node = node.get(prefix.charAt(i));
            }else {
                return false;
            }
        }
        return true;
    }
}
