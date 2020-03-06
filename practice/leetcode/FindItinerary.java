package practice.leetcode;

import java.util.*;

/**
 * Created by liuzhugu on 2020/02/19.
 * 332. 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，
 * 对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
 * 说明:
 *  如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 *  所有的机场都用三个大写字母表示（机场代码）。
 *  假定所有机票至少存在一种合理的行程。
 */
public class FindItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        //逆序插入
        List<String> result = new LinkedList<>();
        if (tickets == null || tickets.size() == 0) {
            return result;
        }
        Map<String,List<String>> map = new HashMap<>();
        for (List<String> pair : tickets) {
            //涉及到删除
            List<String> list = map.computeIfAbsent(pair.get(0),k -> new LinkedList<>());
            list.add(pair.get(1));
        }
        map.values().forEach(x -> x.sort(String :: compareTo));
        visit(map,"JFK",result);
        return result;
    }
    void visit(Map<String,List<String>> map,String src,List result) {
        List<String> list = map.get(src);
        for (String desc : list) {
            visit(map,desc,result);
        }
        //逆序插入
        result.add(0,src);
    }

}
