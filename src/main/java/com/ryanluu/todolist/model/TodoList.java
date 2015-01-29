package com.ryanluu.todolist.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * Represents a list of Tasks that need to be completed.
 * 
 * @author rluu
 *
 */
@Entity
@Table(name="TodoList")
public class TodoList implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    private Date creationDate;
    private Date lastModificationDate;
    
    @OneToMany
    private List<Task> tasks = new LinkedList<>();
    
    
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


    public List<Task> getTasks() {
        return tasks;
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


    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


    @Override
    public String toString() {
	return "TaskList [id=" + id + ", name=" + name + ", tasks=" + tasks
		+ "]";
    }


    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
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
	TodoList other = (TodoList) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (tasks == null) {
	    if (other.tasks != null)
		return false;
	} else if (!tasks.equals(other.tasks))
	    return false;
	return true;
    }
    
    
    
}
