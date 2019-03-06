package practice.leetcode;

import java.util.*;

/**
 * Created by liuzhugu on 2019/03/06
 * 890. 查找和替换模式
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * 返回 words 中与给定模式匹配的单词列表。
 * 你可以按任何顺序返回答案。
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Set<String> chars = new HashSet<>();
        for (char c : pattern.toCharArray()) {
            chars.add(c+"");
        }
        List<List<Integer>> indexList = new ArrayList<>();
        Iterator<String> strs = chars.iterator();
        while (strs.hasNext()) {
            String s = strs.next();
            List<Integer> indexs = new ArrayList<>();
            int index = 0;
            for (char c :pattern.toCharArray()) {
                if (s.equals(c+"")) {
                    indexs.add(index);
                }
                index++;
            }
            indexList.add(indexs);
        }
        List<String> result = new ArrayList<>();
        nextString:for (String string : words) {
            char[] charList = string.toCharArray();
            for (List<Integer> indexs : indexList) {
                for (int i = 0;i < indexs.size();i ++) {
                    if ((i + 1) < indexs.size()) {
                        if (charList[indexs.get(i)] != charList[indexs.get(i + 1)]) {
                            //不匹配 跳过该字符串
                            continue nextString;
                        }
                    }
                }
            }
            result.add(string);
        }
        return result;
    }

//    public static List<String> findAndReplacePattern(String[] words, String pattern) {
//        Set set = new HashSet();
//        for(int i = 0 ; i < pattern.length(); i++){
//            set.add(pattern.charAt(i));
//        }
//        int length = set.size();
//        List<String> list = new ArrayList();
//        for (int i = 0 ; i < words.length; i++){
//            Map<Character,Character> map = new HashMap<>();
//            String str = words[i];
//            boolean flag = true;
//            int sum = 0 ;
//            for(int j = 0 ; j < str.length(); j++){
//                Character c = map.get(str.charAt(j));
//                if(c == null){
//                    map.put(str.charAt(j),pattern.charAt(j));
//                    sum ++;
//                    continue;
//                }
//                if(c == pattern.charAt(j)){
//                    continue;
//                }
//                flag = false;
//                break;
//            }
//            if(flag){
//                if(sum != length){
//                    continue;
//                }
//                list.add(str);
//            }
//        }
//        return list;
//    }
}
