package com.jasmine.core;

import javafx.scene.control.TextArea;

/**
 * Classe responsavel por gerenciar a manipulação da area de texto que é exibida
 * na tela principal
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
public class JasmineMindsHandler {

	public TextArea txtAreaJasmineMinds;

	/**
	 * Get actual text.
	 * 
	 * @return return the actual text
	 */
	String getText() {
		return this.txtAreaJasmineMinds.getText();
	}

	/**
	 * Append the text
	 * 
	 * @param text
	 * @return
	 */
	String appendText(String text) {
		this.txtAreaJasmineMinds.setText(this.txtAreaJasmineMinds.getText().concat(text));
		return this.txtAreaJasmineMinds.getText();
	}

	/**
	 * Append the text with line break in end line
	 * 
	 * @param text
	 *            text to append
	 * @return return the class JasmineMindsHandler
	 */
	JasmineMindsHandler appendTextBreakLine(String text) {
		this.txtAreaJasmineMinds
				.setText(this.txtAreaJasmineMinds.getText().concat(text).concat(System.getProperty("line.separator")));
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
		this.txtAreaJasmineMinds.setText(text);
		return this.txtAreaJasmineMinds.getText();
	}

	/**
	 * Clear all text
	 */
	void clearText() {
		this.txtAreaJasmineMinds.clear();
	}

	/**
	 * Set text area
	 * 
	 * @param textArea
	 */
	public void setTextArea(TextArea textArea) {
		this.txtAreaJasmineMinds = textArea;
	}

}
