package com.the_bean_quartet.msc_project.entities;



import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;






//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="user")

@XmlRootElement
public class SysUser implements Serializable {
	



	/**
	 * 
	 */
	private static final long serialVersionUID = -7686433746648178330L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="User_Id")
	private int id;
	@Column(name="UserName")private String UserName;
	@Column(name="User_Password")private String UserPassword;
	@Column(name="UserType")private String UserType;
	
	public SysUser(){}
	public SysUser(String _UserName, String _UserPassword, String _UserType){
		UserName = _UserName;
		UserPassword = _UserPassword;
		UserType = _UserType;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String UserPassword) {
		this.UserPassword = UserPassword;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String UserType) {
		this.UserType = UserType;
	}
	public int getId() {
		return id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
