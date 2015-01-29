package com.ryanluu.todolist.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String displayName;
    private String username;
    
    @OneToMany
    private List<TodoList> todoList = new LinkedList<>();
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public List<TodoList> getTodoList() {
        return todoList;
    }
    public void setTodoList(List<TodoList> todoList) {
        this.todoList = todoList;
    }
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((displayName == null) ? 0 : displayName.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result
		+ ((todoList == null) ? 0 : todoList.hashCode());
	result = prime * result
		+ ((username == null) ? 0 : username.hashCode());
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
	User other = (User) obj;
	if (displayName == null) {
	    if (other.displayName != null)
		return false;
	} else if (!displayName.equals(other.displayName))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (todoList == null) {
	    if (other.todoList != null)
		return false;
	} else if (!todoList.equals(other.todoList))
	    return false;
	if (username == null) {
	    if (other.username != null)
		return false;
	} else if (!username.equals(other.username))
	    return false;
	return true;
    }
    
    @Override
    public String toString() {
	return "User [id=" + id + ", displayName=" + displayName
		+ ", username=" + username + ", todoList=" + todoList + "]";
    }
    
    
    

}
