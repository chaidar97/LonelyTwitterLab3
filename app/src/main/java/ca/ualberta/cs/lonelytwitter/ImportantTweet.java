package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

/**
 * ImportantTweet class that stores tweet message and date
 * @see: Tweet
 */
public class ImportantTweet extends Tweet {
    /**
     * Constructor for ImportantTweet
     * @param message tweet message
     */
    ImportantTweet(String message){
        super(message);
    }

    /**
     * Constructor for ImportantTweet
     * @param message tweet message
     * @param date date of the tweet
     */
    ImportantTweet(String message, Date date){
        super(message, date);
    }

    /**
     * Returns True to indicate the tweet is important
     * @return True boolean
     */
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
