package com.dbmanager;

/**
 * Pojo class for user table
 * 
 * @author Prashanth Babu
 *
 */
public class UserPojo {

	private int mid;
	private String musername;
	private String mpassword;
	private String memail;
	private String mphonenumber;
	private String mfirstname;
	private String mlastname;
	private String mtype;
	/**
	 * 1 for Enrolled to free lancing course, 2 for Live web hosting
	 */
	private int musertype;
	private int mispaid;
	private int misdeleted;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMusername() {
		return musername;
	}

	public void setMusername(String musername) {
		this.musername = musername;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMphonenumber() {
		return mphonenumber;
	}

	public void setMphonenumber(String mphonenumber) {
		this.mphonenumber = mphonenumber;
	}

	public String getMfirstname() {
		return mfirstname;
	}

	public void setMfirstname(String mfirstname) {
		this.mfirstname = mfirstname;
	}

	public String getMlastname() {
		return mlastname;
	}

	public void setMlastname(String mlastname) {
		this.mlastname = mlastname;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public int getMispaid() {
		return mispaid;
	}

	public void setMispaid(int mispaid) {
		this.mispaid = mispaid;
	}

	public int getMisdeleted() {
		return misdeleted;
	}

	public void setMisdeleted(int misdeleted) {
		this.misdeleted = misdeleted;
	}

	public int getMusertype() {
		return musertype;
	}

	public void setMusertype(int musertype) {
		this.musertype = musertype;
	}

}
