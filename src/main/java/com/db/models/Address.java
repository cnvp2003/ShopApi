package com.db.models;

public class Address {

	private String   number;
	private String   city;
	private String   postCode;
	private Location location;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String toString() {
		return "Location{" +
				"number='" + number + '\'' +
				", city='" + city + '\'' +
				", postCode='" + postCode + '\'' +
				", location='" + location + '\'' +
				'}';
	}
}