package com.cs.todolist.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.lang.String;

/**
 * @author admformation
 * @version 1.0
 * @created 08-nov.-2016 15:23:46
 */

@NamedQueries({
	@NamedQuery(name="findTaskByCreator", query="SELECT entity FROM Task entity "
			+ "WHERE entity.creator=:creator"),
	@NamedQuery(name="findTaskByAssignee", query="SELECT entity FROM Task entity "
			+ "WHERE entity.assignee=:assignee"),
	@NamedQuery(name="findTaskById", query="SELECT entity FROM Task entity "
			+ "WHERE entity.id=:id"),
	@NamedQuery(name="findAllTasks", query="SELECT entity FROM Task entity"),
})

@Entity
@Table(catalog="todolist")
public class Task {
	private User assignee = null;
	private Date closingDate;
	private Date creationDate;
	private User creator;
	private Date deadline;
	private String description;
	private int id;
	private String title;
	private Status status;

	public Task(){
	}

	public Task(User creator, Date deadline, String description, String title) {
		super();
		this.creationDate = new Date();
		this.creator = creator;
		this.deadline = deadline;
		this.description = description;
		this.title = title;
		this.status = Status.NEW;
	}

	@ManyToOne
	@JoinColumn(name="assignee_id")
	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	@Column(name="closing_date")
	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	@Column(name="creation_date")
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@ManyToOne
	@JoinColumn(name="creator_id")
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(unique=true)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}//end Task