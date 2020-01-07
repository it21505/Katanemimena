package it21505.java.project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "Authorities")
public class Authorities {
	
	  @Id  	  
	  @Column(name = "AUTHORITY")
	  private String authority;
	    
	  @ManyToOne
	  @JoinColumn(name = "USERNAME")
	  private User user;
	  
	  public Authorities(){
		  
	  }
	  
	public Authorities(String authority, User user) {
		super();
		this.authority = authority;
		this.user = user;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	  
	  
}
