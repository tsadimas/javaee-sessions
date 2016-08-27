package gr.hua.dit.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;

public class Contact implements Serializable {

	private static final long serialVersionUID = 1410208219313444691L;
	private int id;
	private String name;
	private String surname;
	private int phone;
	private Date birthdate;
	private int user_id;
	
	public Contact(int id, String name, String surname, int phone, Date birthdate, int user_id) {
		this.id=id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.birthdate = birthdate;
		this.user_id = user_id;
	}
	
	public Contact(String name, String surname, int phone, Date birthdate, int user_id) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.birthdate = birthdate;
		this.user_id = user_id;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	
}
