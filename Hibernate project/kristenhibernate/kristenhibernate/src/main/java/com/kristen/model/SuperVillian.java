package com.kristen.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUPER_VILLAIN") // name of table in databse
public class SuperVillian {
	@Id
	@Column(name = "svill_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int svillId;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "superpower")
	private String superpower;

	@Column(name = "bounty")
	private int bounty;
	// if fetch type is lazy, then a proxy will be left in the attribute's place
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Crime> crimes;

	public SuperVillian() {
	}

	public SuperVillian(String name, String superpower, int bounty) {
		super();
		this.name = name;
		this.superpower = superpower;
		this.bounty = bounty;
	}

	public SuperVillian(String name, String superpower, int bounty, List<Crime> crimes) {
		super();
		this.name = name;
		this.superpower = superpower;
		this.bounty = bounty;
		this.crimes = crimes;
	}

	public SuperVillian(int svillId, String name, String superpower, int bounty, List<Crime> crimes) {
		super();
		this.svillId = svillId;
		this.name = name;
		this.superpower = superpower;
		this.bounty = bounty;
		this.crimes = crimes;

	}

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

	public void setSuperpower(String superpower) {
		this.superpower = superpower;
	}

	public int getBounty() {
		return bounty;
	}

	public void setBounty(int bounty) {
		this.bounty = bounty;
	}

	public List<Crime> getCrimes() {
		return crimes;
	}

	public void setCrimes(List<Crime> crimes) {
		this.crimes = crimes;
	}

	@Override
	public String toString() {
		return "SuperVillain[svillId= " + svillId + ", name=" + name + ",superpower=" + bounty + ", crimes=" + crimes
				+ "]\n";
	}

}
