package com.example.demo1.model;

import java.util.Scanner;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



/*@Entity(default)- A Class can be mapped to a table
 * @Table- Specifies the table name
 * @Dynamic Update- Updates the particular value to the attribute which we want to change instead of checking all the attributes.
 * @Id-Considers as a primary key
 * @Generated value(strategy=GenerationType.IDENTITY)- automatically generates the primary key values.
 * @Column-Specifies the column name*/


@Entity
@DynamicUpdate
@Table(name = "Bus_management")
public class BusManagement {


    /* scanner object private to this class is created to accept userInput */
	private static final Scanner scan=new Scanner(System.in);
	public BusManagement() {

	}
	@Column(name="starting_point")
	private String startingPoint;
	
	@Column(name="ending_point")
	private String endingPoint;
	
	@Column(name="driver_name")
	private String driverName;
	
	@Column(name="driver_number")
	private Long driverNumber;
	
	// @Id annotation denotes the primary key of the table created
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bus_id")
	private Integer busId;

	@Column(name="bus_number",length=10)
	private String busNumber;
	
	@Column(name="bus_type")
	private String busType;
	
	
	public String getStartingPoint() {
		return startingPoint;
	}
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	public String getEndingPoint() {
		return endingPoint;
	}
	public void setEndingPoint(String endingPoint) {
		this.endingPoint = endingPoint;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Long getDriverNumber() {
		return driverNumber;
	}
	public void setDriverNumber(Long driverNumber) {
		this.driverNumber = driverNumber;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public Integer getbusId() {
		return busId;
	}
	public void setbusId(int busId) {
		this.busId = busId;
	}
	@Override
	public String toString() {
		return "BusManagement [startingPoint=" + startingPoint + ", endingPoint=" + endingPoint + ", driverName="
				+ driverName + ", driverNumber=" + driverNumber + ", busNumber=" + busNumber + ", busType=" + busType
				+ ",busId=" + busId +"]";
	}
}


