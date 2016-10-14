package com.jasmine.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe responsavel por definir os atributos do documento de usuários
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
@Document(collection = "users")
public class User {

	@Id
	private String id;

	public String login;
	public String password;
	public String accessToken;
	public String accessTokenSecret;

	public User() {
	}

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessTokenSecret() {
		return this.accessTokenSecret;
	}

	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s']", this.id, this.login, this.password);
	}

}
