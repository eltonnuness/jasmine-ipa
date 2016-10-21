package com.jasmine.model;

/**
 * Objeto usado para retornar o resultado de map-reduce feito pelo MongoDB
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
public class ValueObjectMapReduce implements Comparable<ValueObjectMapReduce> {

	private String id;
	private float value;

	public ValueObjectMapReduce() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.format("ValueObjectMapReduce [id=%s, value=%s]", this.id, this.value);
	}

	@Override
	public int compareTo(ValueObjectMapReduce vomr) {
		return Float.valueOf(this.getValue()).compareTo(vomr.getValue());
	}

}
