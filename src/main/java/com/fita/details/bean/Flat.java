package com.fita.details.bean;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flatId;
	private Integer flatNumber;
	private String flatType;
	private Integer numberOfFamilyMembers;
	public Integer getFlatId() {
		return flatId;
	}
	public void setFlatId(Integer flatId) {
		this.flatId = flatId;
	}
	public Integer getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(Integer flatNumber) {
		this.flatNumber = flatNumber;
	}
	public String getFlatType() {
		return flatType;
	}
	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	public Integer getNumberOfFamilyMembers() {
		return numberOfFamilyMembers;
	}
	public void setNumberOfFamilyMembers(Integer numberOfFamilyMembers) {
		this.numberOfFamilyMembers = numberOfFamilyMembers;
	}
	public Flat(Integer flatId, Integer flatNumber, String flatType, Integer numberOfFamilyMembers) {
		super();
		this.flatId = flatId;
		this.flatNumber = flatNumber;
		this.flatType = flatType;
		this.numberOfFamilyMembers = numberOfFamilyMembers;
	}
	public Flat() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Flat [flatId=" + flatId + ", flatNumber=" + flatNumber + ", flatType=" + flatType
				+ ", numberOfFamilyMembers=" + numberOfFamilyMembers + "]";
	}
	public Object getBlock() {
		// TODO Auto-generated method stub
		return null;
	}

   
}

