package com.fita.details.bean;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity
public class Block {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer blockId;
	private String blockName;
//	private Integer floorId;
	@OneToMany
	@JoinColumn(name="blockId")
	private List<Floor> floors;
	@Override
	public String toString() {
		return "Block [blockId=" + blockId + ", blockName=" + blockName + ", floors=" + floors + "]";
	}
	public Block() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Block(Integer blockId, String blockName, List<Floor> floors) {
	super();
	this.blockId = blockId;
	this.blockName = blockName;
	this.floors = floors;
}
	public Integer getBlockId() {
		return blockId;
	}
	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public List<Floor> getFloors() {
		return floors;
	}
	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}


	
   
}

