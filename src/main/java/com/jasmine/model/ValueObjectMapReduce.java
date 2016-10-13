package com.jasmine.model;

public class ValueObjectMapReduce {

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

}
