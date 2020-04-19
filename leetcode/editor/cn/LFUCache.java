package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by liuzhugu on 2019/04/05.
 * 460. LFU缓存
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，
 * 使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，
 * 最近最少使用的键将被去除。一个项目的使用次数就是该项目被插入后对其调用 get 和 put 函数的次数之和。
 * 使用次数会在对应项目被移除后置为 0。
 *
 * 进阶：
 *      你是否可以在 O(1) 时间复杂度内执行两项操作？
 */
public class LFUCache {

    //根据频次找node   根据node找频次

    //缓存
    private Map<Integer,Node> cache;
    //额外维护的频次和node之间的关系  便于根据最小频次和使用时间确定要被删除的节点
    private Map<Integer, LinkedHashSet<Node>> freq;
    //最小频次 根据最小频次找要删除的节点
    private int min;
    //容量
    private int capacity;
    //大小
    private int size;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freq = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //该节点被访问  频率+1
        fraqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        //容量为0  那么不允许添加
        if (capacity == 0) {
            return;
        }
        //如果已有 那么是更新 否则是添加
        Node node = cache.get(key);
        if (node != null) {
            //更新
            node.value = value;
            fraqInc(node);
        } else {
            //添加
            //判断容量  如果满了的话先删再增
            if (capacity == size) {
                //找出频率最小的
                LinkedHashSet<Node> linkedHashSet = freq.get(min);
                //删除最老的  因为是从结尾增加  所以从头删除
                Node firstNode = linkedHashSet.iterator().next();
                linkedHashSet.remove(firstNode);
                cache.remove(firstNode.key);
                size --;
            }
            node = new Node(key,value);
            addNode(node);
            size ++;
        }
    }

    void addNode(Node node) {
        //缓存中添加
        cache.put(node.key,node);
        //频次表中添加
        LinkedHashSet linkedHashSet = freq.get(node.freq);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet();
            freq.put(node.freq,linkedHashSet);
        }
        linkedHashSet.add(node);
        //新增节点频率都是1
        min = 1;
    }

    public void fraqInc(Node node) {
        //从原频次表中删除
        LinkedHashSet linkedHashSet = freq.get(node.freq);
        linkedHashSet.remove(node);
        if (linkedHashSet.size() == 0 && node.freq == min) {
            //如果当前列表是最小频次的  因为是频次+1  那么最小频次也应该+1
            min = node.freq + 1;
        }
        //频次增加
        node.freq ++;
        //放到新频次表
        linkedHashSet = freq.get(node.freq);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet();
            freq.put(node.freq,linkedHashSet);
        }
        linkedHashSet.add(node);
    }

    class Node {
        int key;
        int value;
        int freq = 1;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
