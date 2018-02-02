package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by dezfuli on 1/16/18.
 */

/**
 * Tweet superclass that handles storing messages and dates
 * @see NormalTweet
 * @see ImportantTweet
 */
public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;

    /**
     * Tweet constructor that stores message
     * @param message
     */
    Tweet(String message){

        this.message = message;
        date = new Date();
//        message = message;
    }

    /**
     * Tweet constructor that stores message and date
     * @param message
     * @param date
     */
    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /**
     * Returns the message that the tweet object stores
     * @return the message of the tweet
     */
    public String getMessage(){
        return message;
    }

    /**
     * Sets the message for the Tweet
     * @param message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    /**
     * Returns the date that the tweet was made
     * @return returns the date
     */
    public Date getDate(){
        return date;
    }

    /**
     * Sets the date the tweet was made
     * @param date
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**
     * Abstract method to identify important tweet
     *
     */
    public abstract Boolean isImportant();

    /**
     * Returns the message the Tweet contains
     * @return the message the Tweet contains
     */
    @Override
    public String toString(){
        return message;
    }
}
