package com.jasmine.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import twitter4j.Status;

/**
 * Classe responsavel por definir os atributos das informações de twitter
 * armazenadas.
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
@Document(collection = "usertwitterdata")
public class UserTwitterData {

	@Id
	private String id;
	private User user;
	private Status status;

	public UserTwitterData() {
		super();
	}

	public UserTwitterData(User user, Status status) {
		super();
		this.user = user;
		this.status = status;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format("UserTwitterData [id=%s, user=%s, status=%s]", this.id, this.user, this.status);
	}

}
