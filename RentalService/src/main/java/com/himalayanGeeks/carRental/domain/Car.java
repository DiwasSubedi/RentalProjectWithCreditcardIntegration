package com.himalayanGeeks.carRental.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Car {
	public boolean available;

	@JsonIgnore
	@Transient
	private MultipartFile carImage;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "carTypeidFk")
	private CarType carType;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "companyidFk")
	private Company company;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;

	public String name;

	private int numberOfMiles;
	private int pricePerDay;
	private String year;

	@XmlTransient
	public MultipartFile getCarImage() {
		return carImage;
	}

	public CarType getCarType() {
		return carType;
	}

	public Company getCompany() {
		return company;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfMiles() {
		return numberOfMiles;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public String getYear() {
		return year;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setCarImage(MultipartFile carImage) {
		this.carImage = carImage;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberOfMiles(int numberOfMiles) {
		this.numberOfMiles = numberOfMiles;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Car [carType=" + carType + ", company=" + company + ", id=" + id + ", name=" + name + ", numberOfMiles="
				+ numberOfMiles + ", pricePerDay=" + pricePerDay + ", available=" + available + ", year=" + year + "]";
	}

}
