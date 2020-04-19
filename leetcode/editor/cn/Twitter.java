package leetcode.editor.cn;

import java.util.*;

/**
 * Created by liuzhugu on 2020/04/12.
 * 355. 设计推特
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人
 * （包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *      1.postTweet(userId, tweetId): 创建一条新的推文
 *      2.getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 *      3.follow(followerId, followeeId): 关注一个用户
 *      4.unfollow(followerId, followeeId): 取消关注一个用户
 */
public class Twitter {

    //关注的用户
    private Map<Integer,Set<Integer>> followers;
    //用户发表的推文
    private Map<Integer,List<Article>> twitters;
    //全局序列id  给文章排个序
    private int sequenceId;
    private PriorityQueue<Article> maxHeap;

    /** Initialize your data structure here. */
    public Twitter() {
        twitters = new HashMap<>();
        followers =  new HashMap<>();
        sequenceId = 0;
        maxHeap = new PriorityQueue<>(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o2.sequenceId - o1.sequenceId;
            }
        });
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Article> articles = twitters.get(userId);
        if (articles == null) {
            articles = new LinkedList<>();
            twitters.put(userId,articles);
        }
        articles.add(new Article(userId,tweetId,sequenceId ++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>(10);
        maxHeap.clear();
        //获取该用户关注的用户
        Set<Integer> follower = followers.get(userId);
        if (follower == null || follower.size() == 0) {
            follower =  new LinkedHashSet<>();
            //该用户会关注自己
            follower.add(userId);
            followers.put(userId,follower);
        }
        //获取这些用户的文章
        for (int followerId : follower) {
            if (twitters.get(followerId) != null) {
                maxHeap.addAll(twitters.get(followerId));
            }
        }
        while (maxHeap.size() > 0 && ans.size() < 10) {
            ans.add(maxHeap.poll().twitterId);
        }
        return ans;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        // 被关注人不能是自己
        if (followeeId == followerId) {
            return;
        }
        //该用户关注的人
        Set<Integer> follower = followers.get(followerId);
        if (follower == null) {
            follower =  new LinkedHashSet<>();
            //该用户会关注自己
            follower.add(followerId);
            followers.put(followerId,follower);
        }
        follower.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        //该用户关注的人
        Set<Integer> follower = followers.get(followerId);
        if (follower != null) {
            follower.remove(followeeId);
        }
    }

    class Article {
        int userId;
        int twitterId;
        //全局序列号
        int sequenceId;
        public Article(int userId,int twitterId,int sequenceId) {
            this.userId = userId;
            this.twitterId = twitterId;
            this.sequenceId = sequenceId;
        }
    }
}
