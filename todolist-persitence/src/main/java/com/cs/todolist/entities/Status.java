package com.cs.todolist.entities;


/**
 * @author admformation
 * @version 1.0
 * @created 08-nov.-2016 15:23:46
 */
public enum Status {
	NEW,
	ASSIGNED,
	IN_PROGRESS,
	RESOLVED,
	CLOSED;

	public Task m_Task;
}