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
@Table(name = "tbldemorequest")
public class DemoRequest {

	@Id
	@GeneratedValue
	@Column(name = "fldid")
	private int id;
	@Column(name = "fldemail")
	private String email;
	@Column(name = "fldphonenumber")
	private String phonenumber;
	@Column(name = "fldfirstname")
	private String firstname;
	@Column(name = "fldlastname")
	private String lastname;
	@Column(name = "fldTimeStamp", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
