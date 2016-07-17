package com.db.models;

public class Location {

	public double lat;
	public double lng;

	public Location() {
	}

	public Location(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public String toString() {
		return "Location{" +
				"lat='" + lat + '\'' +
				", lng='" + lng + '\'' +
				'}';
	}
}