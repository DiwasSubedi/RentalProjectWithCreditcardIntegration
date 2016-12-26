package com.himalayanGeeks.carRental.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Insurance {
	public int costPerDay;
	public String coveredType;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;	
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "insuranceIDfk")
    private List<Reservation> insListRese;
	
	public List<Reservation> getInsListRese() {
		return insListRese;
	}

	public void setInsListRese(List<Reservation> insListRese) {
		this.insListRese = insListRese;
	}
	public String name;

	public int getCostPerDay() {
		return costPerDay;
	}

	public String getCoveredType() {
		return coveredType;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setCostPerDay(int costPerDay) {
		this.costPerDay = costPerDay;
	}

	public void setCoveredType(String coveredType) {
		this.coveredType = coveredType;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

}
