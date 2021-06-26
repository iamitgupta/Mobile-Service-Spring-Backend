package com.ms.entity;

public class Design {
	private String dimensions;
	private String weight;

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Design [dimensions=" + dimensions + ", weight=" + weight + "]";
	}

}