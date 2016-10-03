package com.jasmine.conf;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.ApplicationContext;

import com.jasmine.controller.HomeController;
import com.jasmine.controller.LoginController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SpringFxmlLoader {

	private ApplicationContext context;

	public SpringFxmlLoader(ApplicationContext context) {
		this.context = context;
	}

	public Parent loadLogin(String url, Stage stage) throws IOException {

		InputStream fxmlStream = null;

		try {
			fxmlStream = LoginController.class.getResourceAsStream(url);
			LoginController instance = context.getBean(LoginController.class);
			instance.setPrimaryStage(stage);
			FXMLLoader loader = new FXMLLoader();
			loader.setControllerFactory(clazz -> context.getBean(clazz));
			return loader.load(fxmlStream);
		} finally {
			if (fxmlStream != null) {
				fxmlStream.close();
			}
		}

	}

	public Parent loadHome(String url, Stage stage) throws IOException {

		InputStream fxmlStream = null;

		try {
			fxmlStream = HomeController.class.getResourceAsStream(url);
			HomeController instance = context.getBean(HomeController.class);
			instance.setPrimaryStage(stage);
			FXMLLoader loader = new FXMLLoader();
			loader.setControllerFactory(clazz -> context.getBean(clazz));
			return loader.load(fxmlStream);
		} finally {
			if (fxmlStream != null) {
				fxmlStream.close();
			}
		}

	}

}
