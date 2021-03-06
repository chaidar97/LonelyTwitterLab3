package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Activity class that handles the main activity which can
 * display tweets, show the date of tweets, send tweets,
 * and clear tweets
 * @see: Activity, Tweet
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "tweet_list.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	
	/**
	 *  Called when the activity is first created.
	 *  Sets the view for Activity and initializes
	 *  the body text, buttons, and listView, and sets the listener
	 *  @param savedInstanceState
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("LifeCycle ---->", "onCreate is called");
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);



		saveButton.setOnClickListener(new View.OnClickListener() {
			/**
			 * Sets the onclick function which adds the new tweet
			 * @param v
			 */
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);
				adapter.notifyDataSetChanged();
				saveInFile();

			}
		});
	}

	/**
	 * Loads the tweets and sets them in the listView
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("LifeCycle --->", "onStart is called");
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Loads all the tweets from the Gson file TEST
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            tweetList = new ArrayList<Tweet>();
        } catch (IOException e) {
            throw new RuntimeException();
        }
	}

	/**
	 * Saves the tweet objects
	 * @throws RuntimeException
	 * @throws IOException
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(tweetList, out);
            out.flush();

		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Clears all the tweets
	 * @param view
	 */
	public void clear(View view){
        tweetList.clear();
        adapter.notifyDataSetChanged();
	}

	/**
	 * Destroys the activity
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Lifecycle", "onDestroy is called");
	}
}