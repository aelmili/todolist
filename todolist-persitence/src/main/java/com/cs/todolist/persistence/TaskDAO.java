package com.cs.todolist.persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cs.todolist.entities.Status;
import com.cs.todolist.entities.Task;
import com.cs.todolist.entities.User;

/**
 * @author admformation
 * @version 1.0
 * @created 08-nov.-2016 15:23:46
 */

@Repository
public class TaskDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void CreateTask(Task task){
		entityManager.persist(task);
	}

	public List<Task> findAllTasks(){
		Query query = entityManager.createNamedQuery("findAllTasks");

		return query.getResultList();
	}

	public List<Task> findTaskByCreator(User creator){
		Query query = entityManager.createNamedQuery("findTaskByCreator");
		query.setParameter("creator", creator);

		return query.getResultList();
	}

	public List<Task> findTaskByAssignee(User assignee){
		Query query = entityManager.createNamedQuery("findTaskByAssignee");
		query.setParameter("assignee", assignee);

		return query.getResultList();
	}

	public Task findTaskById(int id){
		Query query = entityManager.createNamedQuery("findTaskById");
		query.setParameter("id", id);

		return (Task) query.getSingleResult();
	}

	@Transactional
	public void updateTaskStatus(int taskId, Status newStatus){
		Task task = findTaskById(taskId);
		task.setStatus(newStatus);
		entityManager.persist(task);
	}

	@Transactional
	public void updateTaskAssignee(int taskId, User assignee){
		Task task = findTaskById(taskId);
		task.setAssignee(assignee);
		entityManager.persist(task);
	}

	@Transactional
	public void updateClosingDate(int taskId, Date newClosingDate){
		Task task = findTaskById(taskId);
		task.setClosingDate(newClosingDate);
		entityManager.persist(task);
	}
}//end TaskDAO