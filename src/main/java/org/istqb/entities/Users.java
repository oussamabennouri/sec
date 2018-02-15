package org.istqb.entities;


import javax.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity

public class Users {

    @Id
    @GeneratedValue()
    
    private int id;
    
    private String email;
   
    private String password;
    
    private String name;
   
    private String lastName;

    private int active;
    @Temporal(TemporalType.DATE)
    
	private Date dateNaissance;
   
    private int tel;
    
	private String photo;
   

    public Users() {
    }

    public Users(Users users) {
        this.active = users.getActive();
        this.email = users.getEmail();
        this.name = users.getName();
        this.lastName =users.getLastName();
        this.id = users.getId();
        this.dateNaissance = users.getDateNaissance();
        this.password = users.getPassword();
        this.tel = users.getTel();
        this.photo = users.getPhoto();
    }

  

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

   
}
