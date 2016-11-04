package com.jasmine.conf;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.ApplicationContext;

import com.jasmine.controller.HomeController;
import com.jasmine.controller.LoginController;
import com.jasmine.model.User;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * Classe responsavel por realizar o carregamento dos arquivos FXML do JavaFX e
 * configurar os controllers criados pelo JavaFX para que passem pelo container
 * do spring para que possamos injetar beans neles.
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 *
 */
public class SpringFxmlLoader {

	private ApplicationContext context;

	public SpringFxmlLoader(ApplicationContext context) {
		this.context = context;
	}

	public Parent loadLogin(String url, Stage stage) throws IOException {

		InputStream fxmlStream = null;

		try {
			fxmlStream = LoginController.class.getResourceAsStream(url);
			LoginController instance = this.context.getBean(LoginController.class);
			instance.setPrimaryStage(stage);
			FXMLLoader loader = new FXMLLoader();
			loader.setControllerFactory(clazz -> this.context.getBean(clazz));
			return loader.load(fxmlStream);
		} finally {
			if (fxmlStream != null) {
				fxmlStream.close();
			}
		}

	}

	public Parent loadHome(String url, Stage stage, User user) throws IOException {

		InputStream fxmlStream = null;

		try {
			fxmlStream = HomeController.class.getResourceAsStream(url);
			HomeController instance = this.context.getBean(HomeController.class);
			instance.setPrimaryStage(stage);
			instance.setUser(user);
			FXMLLoader loader = new FXMLLoader();
			loader.setControllerFactory(clazz -> this.context.getBean(clazz));
			return loader.load(fxmlStream);
		} finally {
			if (fxmlStream != null) {
				fxmlStream.close();
			}
		}

	}

}
