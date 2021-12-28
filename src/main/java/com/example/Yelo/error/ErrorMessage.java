package com.example.Yelo.error;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorMessage {
	private String message;
	private String uri;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timeStamp;

	public ErrorMessage() {
		this.timeStamp = new Date();
	}

	public ErrorMessage(String message, String uri) {
		this(); // timestamp
		this.message = message;
		this.uri = uri;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
