package com.jasmine.integrations;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.jasmine.StartJasmine;
import com.jasmine.model.User;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

@Component
public class TwitterConnector {

	private Properties prop = new Properties();

	public Twitter access(User user) throws TwitterException {

		try {
			prop.load(StartJasmine.class.getResourceAsStream("/keys/twitter.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true).setOAuthAccessToken(user.getAccessToken())
				.setOAuthAccessTokenSecret(user.getAccessTokenSecret())
				.setOAuthConsumerKey(prop.getProperty("consumer-key"))
				.setOAuthConsumerSecret(prop.getProperty("consumer-secret"));

		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		return twitter;

	}

	public void authorizeAccessUserData() {

		try {
			prop.load(new FileInputStream("/keys/twitter.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true).setOAuthConsumerKey(prop.getProperty("consumer-key"))
				.setOAuthConsumerSecret("consumer-secret");
		try {
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			try {
				System.out.println("-----");
				RequestToken requestToken = twitter.getOAuthRequestToken();

				System.out.println("Got request token.");
				System.out.println("Request token: " + requestToken.getToken());
				System.out.println("Request token secret: " + requestToken.getTokenSecret());

				System.out.println("|-----");

				AccessToken accessToken = null;

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				while (null == accessToken) {
					System.out.println("Open the following URL and grant access to your account:");
					System.out.println(requestToken.getAuthorizationURL());
					System.out.print("Enter the PIN(if available) and hit enter after you granted access.[PIN]:");
					String pin = br.readLine();

					try {
						if (pin.length() > 0) {
							accessToken = twitter.getOAuthAccessToken(requestToken, pin);
						} else {
							accessToken = twitter.getOAuthAccessToken(requestToken);
						}
					} catch (TwitterException te) {
						if (401 == te.getStatusCode()) {
							System.out.println("Unable to get the access token.");
						} else {
							te.printStackTrace();
						}
					}
				}
				System.out.println("Got access token.");
				System.out.println("Access token: " + accessToken.getToken());
				System.out.println("Access token secret: " + accessToken.getTokenSecret());

			} catch (IllegalStateException ie) {
				// access token is already available, or consumer key/secret is not set.
				if (!twitter.getAuthorization().isEnabled()) {
					System.out.println("OAuth consumer key/secret is not set.");
					System.exit(-1);
				}
			}
			System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get timeline: " + te.getMessage());
			System.exit(-1);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Failed to read the system input.");
			System.exit(-1);
		}

	}

}
