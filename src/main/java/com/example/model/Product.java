package com.example.model;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Product {


	public Product(String name, Integer color) {
		this.name = name;
		this.color = color;
	}

	private String name;

	private Integer color;
}
