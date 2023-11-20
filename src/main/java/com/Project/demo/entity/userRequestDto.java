package com.Project.demo.entity;

public class userRequestDto {

	String latitude;
	String Longitude;
	Long Id;
	String unit;
	String radius;

	public userRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public userRequestDto(String latitude, String longitude, Long id, String radius) {
		super();
		this.latitude = latitude;
		Longitude = longitude;
		Id = id;
		radius = radius;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "userDto [latitude=" + latitude + ", Longitude=" + Longitude + ", Id=" + Id + "]";
	}

}
