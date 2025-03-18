package com.fita.details.bean;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ownerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private Long phoneNumber;
	@OneToOne
	@JoinColumn(name="flatId")
	private Flat flat;
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Flat getFlat() {
		return flat;
	}
	public void setFlat(Flat flat) {
		this.flat = flat;
	}
	public Owner(Integer ownerId, String firstName, String lastName, String emailId, Long phoneNumber, Flat flat) {
		super();
		this.ownerId = ownerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.flat = flat;
	}
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", phoneNumber=" + phoneNumber + ", flat=" + flat + "]";
	}
	

}
