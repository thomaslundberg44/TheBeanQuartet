package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries(
		{
		@NamedQuery(name = "userdata.getAll",
				query = "select data from UserData data where data.id like :User_Id") 
		})

@Entity
@Table(name="user")
public class UserData implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="User_Id")
	private int id;
	
	@Column(name="UserName")private String userName;
	@Column(name="User_Password")private String userPassword;
	@Column(name="UserType")private String userType;
	
	public UserData(){}
	
	public UserData(Integer User_Id, String userName, String userPassword, String userType) {
		//this.date = date;
		this.id=User_Id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userType = userType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
