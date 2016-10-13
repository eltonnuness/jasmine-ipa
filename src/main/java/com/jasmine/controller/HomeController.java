
package com.jasmine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jasmine.service.TwitterService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Component
public class HomeController {

	@FXML
	private TextArea txtAreaJasmineMinds;
	@FXML
	private TextField txtUserMinds;
	@FXML
	private Button btnSay;
	@Autowired
	private TwitterService twitterService;
	private Boolean running = true;
	private Stage primaryStage;

	int a = 1;

	@FXML
	private void initialize() {

		this.twitterService.countTweetWords(null);

		//		Timer timer = new Timer();
		//		TimerTask task = new TimerTask() {
		//			@Override
		//			public void run() {
		//				HomeController.this.txtAreaJasmineMinds.setText("something" + HomeController.this.a++);
		//			}
		//		};
		//
		//		timer.schedule(task, 1000, 5000);
	}

	public void setPrimaryStage(Stage stage) {
		this.primaryStage = stage;
	}

	public Stage getPrimaryStage() {
		return this.primaryStage;
	}

}
