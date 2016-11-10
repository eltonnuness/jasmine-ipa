package com.jasmine.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javafx.scene.control.TextArea;

/**
 * Classe responsavel por gerenciar a manipulação da area de texto que é exibida
 * na tela principal
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
@Component
@Scope(value = "singleton")
public class JasmineMindsHandler {

	public TextArea txtAreaJasmineMinds;

	/**
	 * Get actual text.
	 * 
	 * @return return the actual text
	 */
	String getText() {
		return txtAreaJasmineMinds.getText();
	}

	/**
	 * Append the text
	 * 
	 * @param text
	 * @return
	 */
	String appendText(String text) {
		txtAreaJasmineMinds.setText(txtAreaJasmineMinds.getText().concat(getTimeStamp()).concat(text));
		return txtAreaJasmineMinds.getText();
	}

	/**
	 * Append the text with line break in end line
	 * 
	 * @param text
	 *            text to append
	 * @return return the class JasmineMindsHandler
	 */
	JasmineMindsHandler appendTextBreakLine(String text) {
		txtAreaJasmineMinds.setText(txtAreaJasmineMinds.getText().concat(getTimeStamp()).concat(text)
				.concat(System.getProperty("line.separator")));
		return this;
	}

	/**
	 * Replace the text to passed in parameter
	 * 
	 * @param text
	 *            text to replace
	 * @return Return the text putted
	 */
	String setText(String text) {
		txtAreaJasmineMinds.setText(text);
		return txtAreaJasmineMinds.getText();
	}

	/**
	 * Clear all text
	 */
	void clearText() {
		txtAreaJasmineMinds.clear();
	}

	/**
	 * Set text area
	 * 
	 * @param textArea
	 */
	public void setTextArea(TextArea textArea) {
		txtAreaJasmineMinds = textArea;
	}

	public String getTimeStamp() {
		StringBuilder sb = new StringBuilder();
		LocalDateTime ldt = LocalDateTime.now();
		sb.append("[").append(ldt.format(DateTimeFormatter.ISO_LOCAL_TIME)).append("]").append(" - ");

		return sb.toString();
	}

}
