package com.ryanluu.todolist.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * Represents a task to be completed within a TodoList.
 * 
 * @author rluu
 *
 */
@Entity
@Table(name="Task")
public class Task implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public enum TaskState {
	COMPLETE,    // Task has been completed.
	INCOMPLETE,  // Task has not been completed yet.
	DEFERRED,    // State which means the task is put off to an unknown future date.
	
    }
   
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String description;
    private Date creationDate;
    private Date lastModificationDate;
    private Date dueDate;
    
    @Enumerated(EnumType.STRING)
    private Task.TaskState taskState;
    

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
    public Task.TaskState getTaskState() {
        return taskState;
    }

    public void setTaskState(Task.TaskState taskState) {
        this.taskState = taskState;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((creationDate == null) ? 0 : creationDate.hashCode());
	result = prime * result
		+ ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime
		* result
		+ ((lastModificationDate == null) ? 0 : lastModificationDate
			.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result
		+ ((taskState == null) ? 0 : taskState.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Task other = (Task) obj;
	if (creationDate == null) {
	    if (other.creationDate != null)
		return false;
	} else if (!creationDate.equals(other.creationDate))
	    return false;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (dueDate == null) {
	    if (other.dueDate != null)
		return false;
	} else if (!dueDate.equals(other.dueDate))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (lastModificationDate == null) {
	    if (other.lastModificationDate != null)
		return false;
	} else if (!lastModificationDate.equals(other.lastModificationDate))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (taskState != other.taskState)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Task [id=" + id + ", name=" + name + ", description="
		+ description + ", creationDate=" + creationDate
		+ ", lastModificationDate=" + lastModificationDate
		+ ", dueDate=" + dueDate + ", taskState=" + taskState + "]";
    }

    
}
