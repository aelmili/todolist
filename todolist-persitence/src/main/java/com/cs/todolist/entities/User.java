package com.cs.todolist.entities;

import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author admformation
 * @version 1.0
 * @created 08-nov.-2016 15:23:46
 */

@NamedQueries({
	@NamedQuery(name="findByCredentials", query="SELECT entity FROM User entity "
			+ "WHERE entity.email=:email AND entity.password=:password"),
	@NamedQuery(name="findById", query="SELECT entity FROM User entity "
			+ "WHERE entity.id=:id"),
})

@Entity
@Table(catalog="todolist")
public class User {
	private int id;
	private boolean admin;
	private Date birthday;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private Date registrationDate;
	private List<Task> tasks;

	public User(){
		
	}
	
	public User(String email, String firstName, String lastName, String password, Date birthday) {
		super();
		this.birthday = birthday;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
		this.lastName = name;
	}

	@Column(name="registration_date")
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date date) {
		this.registrationDate = date;
	}

	@OneToMany(mappedBy="assignee")
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}//end User