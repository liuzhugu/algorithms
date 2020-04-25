//设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存
//被填满时，它应该删除最近最少使用的项目。 
//
// 它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计

package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Java：面试题 16.25:LRU缓存  2020/04/23
public class LruCacheLcci{
    public static void main(String[] args) {
        LRUCache cache = new LruCacheLcci().new LRUCache(2);

        //TO TEST
        cache.get(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        cache.get(1);
        cache.get(2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        //缓存
        private Map<Integer,Integer> cache;
        //缓存使用顺序
        private Deque<Integer> frequency;
        //最大容量
        private int capacity;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            frequency = new LinkedList<>();
        }

        public int get(int key) {
            if (cache.get(key) != null) {
                //该缓存被查询 成为最热的次
                frequency.remove(key);
                frequency.addFirst(key);
                return cache.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (frequency.contains(key)) {
                frequency.remove(key);
                frequency.addFirst(key);
                cache.put(key,value);
                return;
            }
            //未出现过的key
            if (frequency.size() == capacity) {
                cache.put(key,value);
                cache.remove(frequency.removeLast());
                frequency.addFirst(key);
            } else {
                cache.put(key,value);
                frequency.addFirst(key);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}