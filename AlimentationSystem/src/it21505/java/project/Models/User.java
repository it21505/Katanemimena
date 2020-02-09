package it21505.java.project.Models;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {	
	
	@Id
	@Column(name = "USERNAME")
	 private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "ENABLED", nullable = false)
	private boolean enabled;
	
	@Column(name = "NAME", nullable = false)
	 private String name;

	@Column(name = "SURNAME", nullable = false)
	private String surname;

	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	//Problem when using cascadeType=ALL - I can't have more than one user with same authority
	@OneToMany(/*cascade = CascadeType.ALL,*/ mappedBy = "user",fetch = FetchType.EAGER)
	private Set<Authorities> authorities = new HashSet<>();;

	public User() {
		
	}
	
	public User(String username, String password, String name , String surname , String email) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = true;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
