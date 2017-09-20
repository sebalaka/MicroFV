package sda.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by RENT on 2017-09-13.
 */
@Entity
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String NIP;
	private String address;
	private String telephone;
	private String email;

	public CustomerEntity() {
	}

	public CustomerEntity(Long id, String name, String NIP, String address, String telephone, String email) {
		this.id = id;
		this.name = name;
		this.NIP = NIP;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNIP() {
		return NIP;
	}

	public void setNIP(String NIP) {
		this.NIP = NIP;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
