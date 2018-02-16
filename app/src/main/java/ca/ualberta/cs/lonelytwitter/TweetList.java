package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Chady on 2018-02-15.
 */

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) throws IllegalArgumentException {
        if(tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }

    public Boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }


    public int getCount() {
        return tweets.size();
    }

    public TweetList getTweets() {
        Collections.sort(tweets, new Comparator<Tweet>(){
            public int compare(Tweet t1, Tweet t2) {
                return t1.getDate().compareTo(t2.getDate());

            }
        });
        return this;
    }
}
