package com.jwjibilian.model.reimbursement;

import java.awt.Image;
import java.time.LocalDate;

import com.jwjibilian.model.user.Admin;
import com.jwjibilian.model.user.Client;


public class Reimbursement {
	private int id;
	private int ammount;
	private LocalDate timeSubmitted;
	private LocalDate timeResolved;
	private String description;
	private Image recipit;
	private Client author;
	private Admin resolver;
	private String status;
	private String type;
	
	
	
	public Reimbursement() {
		super();
	}



	public Reimbursement(int id, int ammount, LocalDate timeSubmitted, LocalDate timeResolved, String description,
			Image recipit, Client author, Admin resolver, String status, String type) {
		super();
		this.id = id;
		this.ammount = ammount;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.description = description;
		this.recipit = recipit;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getAmmount() {
		return ammount;
	}



	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}



	public LocalDate getTimeSubmitted() {
		return timeSubmitted;
	}



	public void setTimeSubmitted(LocalDate timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}



	public LocalDate getTimeResolved() {
		return timeResolved;
	}



	public void setTimeResolved(LocalDate timeResolved) {
		this.timeResolved = timeResolved;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Image getRecipit() {
		return recipit;
	}



	public void setRecipit(Image recipit) {
		this.recipit = recipit;
	}



	public Client getAuthor() {
		return author;
	}



	public void setAuthor(Client author) {
		this.author = author;
	}



	public Admin getResolver() {
		return resolver;
	}



	public void setResolver(Admin resolver) {
		this.resolver = resolver;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", ammount=" + ammount + ", timeSubmitted=" + timeSubmitted
				+ ", timeResolved=" + timeResolved + ", description=" + description + ", recipit=" + recipit
				+ ", author=" + author + ", resolver=" + resolver + ", status=" + status + ", type=" + type + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ammount;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((recipit == null) ? 0 : recipit.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((timeResolved == null) ? 0 : timeResolved.hashCode());
		result = prime * result + ((timeSubmitted == null) ? 0 : timeSubmitted.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		System.out.println("Reimbursment equals method called.");
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Reimbursement))
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (ammount != other.ammount)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (recipit == null) {
			if (other.recipit != null)
				return false;
		} else if (!recipit.equals(other.recipit))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (timeResolved == null) {
			if (other.timeResolved != null)
				return false;
		} else if (!timeResolved.equals(other.timeResolved))
			return false;
		if (timeSubmitted == null) {
			if (other.timeSubmitted != null)
				return false;
		} else if (!timeSubmitted.equals(other.timeSubmitted))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
}
