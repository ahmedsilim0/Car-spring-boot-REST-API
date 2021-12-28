package com.example.Yelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cars")
public class Car {
	@Id
	private String id;
	private String name;
	private String color;
	private String model;
	private String owner;
	private boolean hideMe = true;
	private long timeStamp;

	public Car() {
		this.timeStamp = System.currentTimeMillis();
	}

	public Car(String id, String name, String color, String model, String owner, boolean hideMe) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.model = model;
		this.owner = owner;
		this.hideMe = hideMe;
		this.timeStamp = System.currentTimeMillis();
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public boolean isHideMe() {
		return hideMe;
	}

	public void setHideMe(boolean hideMe) {
		this.hideMe = hideMe;
	}

}
