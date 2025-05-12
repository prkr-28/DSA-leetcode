class Tweet implements Comparable<Tweet>{
    int tweet_id;
    int time;
    public Tweet(int i,int t){
        this.tweet_id=i;
        this.time=t;
    }
    public int compareTo(Tweet that){
        return that.time-this.time;
    }
}

class User{
    int user_id;
    HashSet<Integer>followers;
    LinkedList<Tweet>tweets;
    public User(int i){
        this.user_id=i;
        followers=new HashSet<>();
        tweets=new LinkedList<>();
    }
    public void addtweet(Tweet t){
        tweets.add(0,t);
    }
    public void addfollower(int followeeId){
        followers.add(followeeId);
    }
    public void removefollower(int followeeId){
        followers.remove(followeeId);
    }
}

class Twitter {
    HashMap<Integer,User>usermap;
    int time;
    public Twitter() {
        time=0;
        usermap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        if(!usermap.containsKey(userId)){
            usermap.put(userId,new User(userId));
        }
        User user=usermap.get(userId);
        user.addtweet(new Tweet(tweetId,time));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!usermap.containsKey(userId)){
            return new ArrayList<>();
        }
        PriorityQueue<Tweet>pq=new PriorityQueue<>();
        List<Integer>newsfeed=new ArrayList<>();
        //add self and followers tweets
        User user=usermap.get(userId);
        for(int followerid:user.followers){
            int count=0;
            for(Tweet tweet:usermap.get(followerid).tweets){
                pq.add(tweet);
                count++;
                if(count>10){
                    break;
                }
            }
        }

        int count=0;
        for(Tweet tweet:usermap.get(userId).tweets){
            pq.add(tweet);
            count++;
            if(count>10){
                break;
            }
        }
        count=0;
        while(!pq.isEmpty()&&count<10){
            newsfeed.add(pq.poll().tweet_id);
            count++;
        }
        return newsfeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!usermap.containsKey(followerId)){
            usermap.put(followerId,new User(followerId));
        }
        if(!usermap.containsKey(followeeId)){
            usermap.put(followeeId,new User(followeeId));
        }
        User user=usermap.get(followerId);
        user.addfollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!usermap.containsKey(followerId)||!usermap.containsKey(followeeId)){
            return;
        }
        User user=usermap.get(followerId);
        user.removefollower(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */