package com.example.model;

public class CartoonCharacter {
	private String name;
	private String show;
	private String network;
	
	public CartoonCharacter() {
	}

	public CartoonCharacter(String name, String show, String network) {
		super();
		this.name = name;
		this.show = show;
		this.network = network;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	@Override
	public String toString() {
		return "CartoonCharacter [name=" + name + ", show=" + show + ", network=" + network + "]\n";
	}
	
}
