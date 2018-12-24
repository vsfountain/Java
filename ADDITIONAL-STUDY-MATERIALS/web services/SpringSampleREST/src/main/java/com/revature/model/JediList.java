package com.revature.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="jedis")
public class JediList {
	private List<Jedi> jediList;
	
	public JediList() {}
	
	public JediList(List<Jedi> jediList) {
		this.jediList = jediList;
	}

	public List<Jedi> getJediList() {
		return jediList;
	}

	public void setJediList(List<Jedi> jediList) {
		this.jediList = jediList;
	}
}
