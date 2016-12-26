package com.himalayanGeeks.carRental.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	@Valid
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "addressidFk")
    private Address address;


	@NotEmpty
	@Email
	public String email;
	@NotEmpty
	@Size(min=2, max=50)
	public String firstName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	@NotEmpty
	@Size(min=2, max=50)
	public String lastName;
	@NotEmpty
	@Lob 
	@Column(name="password", length=5000)
	public String password;
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "userIdFk")
    private List<Reservation> reservation;
	@OneToOne(mappedBy="user", cascade={CascadeType.ALL})
	private Role role;
	public String userName;
	
	public Address getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	public String getFirstName() {
		return firstName;
	}
	public int getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}


	public List<Reservation> getReservation() {
		return reservation;
	}


	public Role getRole() {
		return role;
	}


	public String getUserName() {
		return userName;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userName=" + userName + ", role=" + role + ", address=" + address
				+ ", reservation=" + reservation + "]";
	}


	
	
	
	
	
	
	
}
