//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写
//入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
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

//Java：146:LRU缓存机制 2020/04/30
public class LruCache{
    public static void main(String[] args) {
        LRUCache cache = new LruCache().new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private int capacity;
        private int count;
        //记录访问顺序
        private Deque<Integer> deque;
        //真正存放数据的地方
        Map<Integer,Integer> cache;
        public LRUCache(int capacity) {
            deque = new LinkedList<>();
            this.capacity = capacity;
            count = 0;
            cache = new HashMap<>(capacity);
        }

        public int get(int key) {
            if (cache.get(key) == null) {
                return -1;
            } else {
                //更新使用顺序
                deque.remove(key);
                deque.addFirst(key);
                return cache.get(key);
            }
        }

        public void put(int key, int value) {
            if (cache.get(key) == null) {
                //插入
                if (count == capacity) {
                    //满了 删一个
                    int deleteKey = deque.removeLast();
                    //清除对应缓存
                    cache.remove(deleteKey);
                    count --;
                }
                count ++;
                cache.put(key,value);
                deque.addFirst(key);
            } else {
                //只是更新
                cache.put(key,value);
                //更新使用顺序
                deque.remove(key);
                deque.addFirst(key);
            }
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)

}