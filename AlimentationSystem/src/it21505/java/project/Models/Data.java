package it21505.java.project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data")
public class Data {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name= "STUDENT_LIMIT")
	private String limit;	
	
	@Column(name= "OPEN")
	private boolean open;
	
	@Column(name = "STUDENT_NUMBER")
	private int total;
	
	public Data() {
		
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
