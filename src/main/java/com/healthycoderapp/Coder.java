package com.healthycoderapp;

import com.healthycoderapp.Exceptions.NegativeValueException;
import com.healthycoderapp.Exceptions.ZeroValueException;

public class Coder {
	
	private double height;
	private double weight;
	private int age;
	private Gender gender;
		
	public Coder(double height, double weight) throws NegativeValueException, ZeroValueException {
		super();
		if (height < 0) {
			throw new NegativeValueException("height");
		}
		if (weight < 0) {
			throw new NegativeValueException("weight");
		}
		if (height == 0) {
			throw new ZeroValueException("height");
		}
		if (weight == 0) {
			throw new ZeroValueException("height");
		}
		this.height = height;
		this.weight = weight;
	}
	
	public Coder(double height, double weight, int age, Gender gender) {
		super();
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}	
}
