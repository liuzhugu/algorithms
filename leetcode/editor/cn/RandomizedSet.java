package leetcode.editor.cn;


import java.util.*;
/**
 * Created by liuzhugu on 2020/01/01.
 * 380. 常数时间插入、删除和获取随机元素
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 */
public class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> keys;
    public RandomizedSet() {
        map = new HashMap<>();
        keys = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.get(val) == null) {
            map.put(val,val);
            keys.add(val);
            return true;
        }else {
            return false;
        }
    }

    public boolean remove(int val) {
        if (map.get(val) != null) {
            map.remove(val,val);
            clean();
            return true;
        }else {
            return false;
        }
    }

    public int getRandom() {
        int size = map.size();
        Integer result = null;
        int index = new Random().nextInt(size);
        while (result == null && index < keys.size()) {
            result = map.get(keys.get(index ++));
        }
        return result;
    }

    //冗余值太多时清除
    void clean() {
        if (keys.size() > map.size() * 2) {
            List<Integer> newKeys = new ArrayList<>();
            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                newKeys.add(entry.getValue());
            }
            keys = newKeys;
        }
    }
}
