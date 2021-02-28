package com.cepheid.cloud.skel.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="item")
public class Item extends AbstractEntity {
	public enum State {
	    UNDEFINED, VALID, INVALID;
	}
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private State state;
	
	@OneToMany(targetEntity = Description.class, cascade = CascadeType.ALL)
	@JoinColumn(name="mId")
	private Set<Description> description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String toString() {
		return this.getId()+"-"+this.getName()+"-"+this.getState();
	}
	public Set<Description> getDescription() {
		return description;
	}

	public void setDescription(Set<Description> description) {
		this.description = description;
	}
	
}
