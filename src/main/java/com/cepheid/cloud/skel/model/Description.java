package com.cepheid.cloud.skel.model;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="description")
public class Description {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long descId;
	
	private String desc;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="mId",referencedColumnName = "mId")
	private Item item;	
	
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getDescId() {
		return descId;
	}

	public void setDescId(Long descId) {
		this.descId = descId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
