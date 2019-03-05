package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuzhugu on 2019/03/05.
 * 677. 键值映射
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，
 * 那么原来的键值对将被替代成新的键值对。对于方法 sum，你将得到一个表示前缀的字符串，
 * 你需要返回所有以该前缀开头的键的值的总和
 */
public class MapSum {

    Map<String,Integer> values;
    public MapSum() {
        values = new HashMap<>();
    }

    public void insert(String key, int val) {
        values.put(key,val);
    }

    public int sum(String prefix) {
        int result = 0;
        for (Map.Entry<String,Integer> entry : values.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                result = result + entry.getValue();
            }
        }
        return result;
    }

}
