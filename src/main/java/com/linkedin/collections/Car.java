package com.linkedin.collections;

import java.util.Objects;

public class Car {

	private String make;

	private String model;

	private int mileage;

	public Car(String make, String model, int mileage) {
		super();
		this.make = make;
		this.model = model;
		this.mileage = mileage;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return Objects.equals(make, car.make) && Objects.equals(model, car.model);
	}

	@Override
	public int hashCode() {
		return Objects.hash(make, model);
	}
}
