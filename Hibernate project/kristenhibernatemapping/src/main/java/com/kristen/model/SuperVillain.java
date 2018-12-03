package com.kristen.model;

public class SuperVillain {
	private int svillId;
	private String name;
	private String superpower;
	private int bounty;

	public int getSvillId() {
		return svillId;
	}

	public void setSvillId(int svillId) {
		this.svillId = svillId;
	}

	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuperpower() {
		return superpower;
	}

	public void setSuperPower(String superpower) {
		this.superpower = superpower;
	}

	public int getBounty() {
		return bounty;

	}

	public void setBounty(int bounty) {
		this.bounty = bounty;
	}

	public SuperVillain() {
	}

	public SuperVillain(String name, String superpower, int bounty) {
		super();
		this.name = name;
		this.superpower = superpower;
		this.bounty = bounty;
	}

	public SuperVillain(int svillId, String name, String superpower, int bounty) {
		super();
		this.name = name;
		this.superpower = superpower;
		this.bounty = bounty;
	}

	@Override
	public String toString() {
		return "SuperVillain [svillId=" + svillId + ", name = " + name + ",superpower=" + superpower + ",bounty="
				+ bounty + "]";

	}

}
