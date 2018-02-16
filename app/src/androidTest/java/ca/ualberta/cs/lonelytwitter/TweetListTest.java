package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.io.IOException;

/**
 * Created by Chady on 2018-02-15.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Adding a normal tweet.");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
        try{
            tweets.add(tweet);
        } catch (IllegalArgumentException e){
            assertTrue(Boolean.FALSE);
        }
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Adding a normal tweet.");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Adding a normal tweet.");
        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getDate(), tweet.getDate());

    }

    public void testDeleteTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Adding a normal tweet.");
        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetCount() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Adding a normal tweet.");
        tweets.add(tweet);
        assertEquals(1,tweets.getCount());
    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("1");
        Tweet tweet2 = new NormalTweet("2");
        Tweet tweet3 = new NormalTweet("3");
        tweets.add(tweet);
        tweets.add(tweet2);
        tweets.add(tweet3);
        assertEquals(tweets, tweets.getTweets());
    }

}
