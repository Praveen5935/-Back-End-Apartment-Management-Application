package com.fita.details.bean;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
@Entity
public class Floor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer floorId;
	private String floorName;
	@OneToMany
	@JoinColumn(name="floorId")
	private List<Flat> flats;
	public Integer getFloorId() {
		return floorId;
	}
	public void setFloorId(Integer floorId) {
		this.floorId = floorId;
	}
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	public List<Flat> getFlats() {
		return flats;
	}
	public void setFlats(List<Flat> flats) {
		this.flats = flats;
	}
	public Floor(Integer floorId, String floorName, List<Flat> flats) {
		super();
		this.floorId = floorId;
		this.floorName = floorName;
		this.flats = flats;
	}
	public Floor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Floor [floorId=" + floorId + ", floorName=" + floorName + ", flats=" + flats + "]";
	}


}
