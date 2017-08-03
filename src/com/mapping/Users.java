package com.mapping;

import java.util.Date;

import javax.persistence.*;

/**
 * For table pojo mapping
 * 
 * @author Prashanth Babu
 *
 */
@Entity
@Table(name = "tbluserdetails")
public class Users {

	@Id
	@GeneratedValue
	@Column(name = "flduserid")
	private int id;
	@Column(name = "fldusername")
	private String username;
	@Column(name = "fldpassword")
	private String password;
	@Column(name = "fldemail")
	private String email;
	@Column(name = "fldphonenumber")
	private String phonenumber;
	@Column(name = "fldfirstname")
	private String firstname;
	@Column(name = "fldlastname")
	private String lastname;
	/**
	 * 1 for Enrolled to free lancing course, 2 for Live web hosting
	 */
	@Column(name = "fldtype")
	private int usertype;
	@Column(name = "fldispaid")
	private int ispaid;
	@Column(name = "fldisdeleted")
	private int isdeleted;
	@Column(name = "fldTimeStamp", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getIspaid() {
		return ispaid;
	}

	public void setIspaid(int ispaid) {
		this.ispaid = ispaid;
	}

	public int getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(int isdeleted) {
		this.isdeleted = isdeleted;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
