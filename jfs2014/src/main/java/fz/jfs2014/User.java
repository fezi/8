package fz.jfs2014;

import javax.persistence.*;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String email;
	private String name;
	private String password;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}