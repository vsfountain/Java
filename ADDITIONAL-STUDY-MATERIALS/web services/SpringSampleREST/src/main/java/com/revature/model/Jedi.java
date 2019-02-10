package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/* Jedi Business Object */
@Entity
@Table(name="JEDI")
@XmlRootElement(name = "jedi")
@XmlAccessorType(XmlAccessType.FIELD)
public class Jedi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JEDI_SEQ")
	@SequenceGenerator(name="JEDI_SEQ", sequenceName="JEDI_SEQ", allocationSize=1)
	@Column(name="J_ID")
	@XmlAttribute
	private int id;
	
	@Column(name="J_NAME")
	@XmlElement
	private String name;
	
	@Column(name="J_SABER_COLOR")
	@XmlElement
	private String saberColor;
	
	public Jedi() {}
	
	public Jedi(String name) {
		this.name = name;
	}
	
	public Jedi(int id, String name, String saberColor) {
		this.id = id;
		this.name = name;
		this.saberColor = saberColor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSaberColor() {
		return saberColor;
	}

	public void setSaberColor(String saberColor) {
		this.saberColor = saberColor;
	}

	@Override
	public String toString() {
		return "Jedi [id=" + id + ", name=" + name + ", saberColor=" + saberColor + "]";
	}
}
