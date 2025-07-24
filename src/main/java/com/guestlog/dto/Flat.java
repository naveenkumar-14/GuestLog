package com.guestlog.dto;

public class Flat {
    private String flatNumber;    
    private int floorNumber;
    private String flatType;     
    private int areaInSqft;   
    private String ownerName;          
    private String ownerContact;       
    private String occupancyStatus; 
    private String tenantName;   
    private String tenantContact;
	public String getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	public String getFlatType() {
		return flatType;
	}
	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	public int getAreaInSqft() {
		return areaInSqft;
	}
	public void setAreaInSqft(int areaInSqft) {
		this.areaInSqft = areaInSqft;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerContact() {
		return ownerContact;
	}
	public void setOwnerContact(String ownerContact) {
		this.ownerContact = ownerContact;
	}
	public String getOccupancyStatus() {
		return occupancyStatus;
	}
	public void setOccupancyStatus(String occupancyStatus) {
		this.occupancyStatus = occupancyStatus;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getTenantContact() {
		return tenantContact;
	}
	public void setTenantContact(String tenantContact) {
		this.tenantContact = tenantContact;
	}
    
    
}

