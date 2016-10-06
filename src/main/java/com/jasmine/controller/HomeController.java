
package com.jasmine.controller;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jasmine.integrations.TwitterConnector;
import com.jasmine.model.User;
import com.mongodb.Mongo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import twitter4j.TwitterException;

@Component
public class HomeController {

	@FXML
	private TextArea txtAreaJasmineMinds;
	@FXML
	private TextField txtUserMinds;
	@FXML
	private Button btnSay;
	@Autowired
	private TwitterConnector twitterConnector;
	@Autowired
	private Mongo mongo;

	private Boolean running = true;

	private Stage primaryStage;

	int a = 1;

	@FXML
	private void initialize() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				HomeController.this.txtAreaJasmineMinds.setText("something" + HomeController.this.a++);
			}
		};

		timer.schedule(task, 1000, 5000);
	}

	@FXML
	private void testPersist() {
		User user = new User();
		try {
			this.twitterConnector.access(user);

			this.mongo.getDB("jasmine-data");

		} catch (TwitterException e) {

			e.printStackTrace();
		}

	}

	public void setPrimaryStage(Stage stage) {
		this.primaryStage = stage;
	}

	public Stage getPrimaryStage() {
		return this.primaryStage;
	}

}
