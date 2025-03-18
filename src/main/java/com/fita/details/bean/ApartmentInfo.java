package com.fita.details.bean;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


	@Entity
	public class ApartmentInfo {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer appartmentId;
		private String appartmentName;
		private String appartmentAddress;
		private Long appartmentPincode;
		@OneToMany
		@JoinColumn(name="appartmentId")
		private List<Block> blocks;

		public ApartmentInfo() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Integer getAppartmentId() {
			return appartmentId;
		}

		public void setAppartmentId(Integer appartmentId) {
			this.appartmentId = appartmentId;
		}

		public String getAppartmentName() {
			return appartmentName;
		}

		public void setAppartmentName(String appartmentName) {
			this.appartmentName = appartmentName;
		}

		public String getAppartmentAddress() {
			return appartmentAddress;
		}

		public void setAppartmentAddress(String appartmentAddress) {
			this.appartmentAddress = appartmentAddress;
		}

		public Long getAppartmentPincode() {
			return appartmentPincode;
		}

		public void setAppartmentPincode(Long appartmentPincode) {
			this.appartmentPincode = appartmentPincode;
		}

		public List<Block> getBlocks() {
			return blocks;
		}

		public void setBlocks(List<Block> blocks) {
			this.blocks = blocks;
		}

		public ApartmentInfo(Integer appartmentId, String appartmentName, String appartmentAddress,
				Long appartmentPincode, List<Block> blocks) {
			super();
			this.appartmentId = appartmentId;
			this.appartmentName = appartmentName;
			this.appartmentAddress = appartmentAddress;
			this.appartmentPincode = appartmentPincode;
			this.blocks = blocks;
		}

		@Override
		public String toString() {
			return "ApartmentInfo [appartmentId=" + appartmentId + ", appartmentName=" + appartmentName
					+ ", appartmentAddress=" + appartmentAddress + ", appartmentPincode=" + appartmentPincode
					+ ", blocks=" + blocks + "]";
		}

		

		
		

	 
	    
	}

	
	




	