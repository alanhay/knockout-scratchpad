package com.certait.knockout.model;

public class DataModel {

	private Character gender;
	private int age;

	public DataModel() {

	}

	public DataModel(Character gender, int age) {
		this.gender = gender;
		this.age = age;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMale() {
		return gender == 'M';
	}

	public boolean isFemale() {
		return gender == 'F';
	}
}
