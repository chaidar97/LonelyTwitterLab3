package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

/**
 * Tweetable interface
 */
public interface Tweetable {
    /**
     * Method to get message
     */
    public String getMessage();

    /**
     * Method to set message
     */
    public Date getDate();
}
