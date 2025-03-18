package com.fita.details.bean;
import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Visitor {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer visitorId;
		private String firstName;
		private String lastName;
		private LocalDate visitingDate;
		@ManyToMany
		@JoinTable(name ="visitor_flat",joinColumns=@JoinColumn(name="visitorId"),inverseJoinColumns=@JoinColumn(name="flatId") ) 
		private List<Flat> visitingflatsInfo;
		public Integer getVisitorId() {
			return visitorId;
		}
		public void setVisitorId(Integer visitorId) {
			this.visitorId = visitorId;
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
		public LocalDate getVisitingDate() {
			return visitingDate;
		}
		public void setVisitingDate(LocalDate visitingDate) {
			this.visitingDate = visitingDate;
		}
		public List<Flat> getVisitingflatsInfo() {
			return visitingflatsInfo;
		}
		public void setVisitingflatsInfo(List<Flat> visitingflatsInfo) {
			this.visitingflatsInfo = visitingflatsInfo;
		}
		public Visitor(Integer visitorId, String firstName, String lastName, LocalDate visitingDate,
				List<Flat> visitingflatsInfo) {
			super();
			this.visitorId = visitorId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.visitingDate = visitingDate;
			this.visitingflatsInfo = visitingflatsInfo;
		}
		public Visitor() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Visitor [visitorId=" + visitorId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", visitingDate=" + visitingDate + ", visitingflatsInfo=" + visitingflatsInfo + "]";
		}
				
		

   
}
