package com.db.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Shop {

	private String   id;
	private String   name;
	private Address  address;

	ObjectMapper mapper = new ObjectMapper();

	public Shop() {
	}

	public String getId() {
		return id;
	}

	public Shop setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Shop setName(String name) {
		this.name = name;
		return this;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String toJson() {
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}

	public Shop fromJson(String payload) {
		try {
			return mapper.readValue(payload, Shop.class);
		} catch (IOException e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}

	public String toString() {
		return "Location{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}