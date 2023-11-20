package com.Project.demo.entity;

public class UserResponse {

	String latitude;
	String longitude;
	String firstname;
	String lastname;

	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserResponse(String latitude, String longitude, String name) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "UserResponse [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
