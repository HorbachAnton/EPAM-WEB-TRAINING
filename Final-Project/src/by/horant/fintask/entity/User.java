package by.horant.fintask.entity;

import by.horant.fintask.entity.enumeration.Roles;

public class User {

    private int id;
    private String email;
    private String password;
    private String firstName;
    private String secondName;
    private Roles role;

    public User() {

    }

    public User(int id, String email, String password, String firstName, String secondName, Roles role) {
	this.id = id;
	this.email = email;
	this.password = password;
	this.firstName = firstName;
	this.secondName = secondName;
	this.role = role;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getSecondName() {
	return secondName;
    }

    public void setSecondName(String secondName) {
	this.secondName = secondName;
    }

    public Roles getRole() {
	return role;
    }

    public void setRole(Roles role) {
	this.role = role;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + id;
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	User other = (User) obj;
	if (email == null) {
	    if (other.email != null) {
		return false;
	    }
	} else if (!email.equals(other.email)) {
	    return false;
	}
	if (firstName == null) {
	    if (other.firstName != null) {
		return false;
	    }
	} else if (!firstName.equals(other.firstName))
	    return false;
	if (id != other.id)
	    return false;
	if (password == null) {
	    if (other.password != null) {
		return false;
	    }
	} else if (!password.equals(other.password))
	    return false;
	if (role != other.role)
	    return false;
	if (secondName == null) {
	    if (other.secondName != null) {
		return false;
	    }
	} else if (!secondName.equals(other.secondName))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
		+ ", secondName=" + secondName + ", role=" + role + "]";
    }

}
