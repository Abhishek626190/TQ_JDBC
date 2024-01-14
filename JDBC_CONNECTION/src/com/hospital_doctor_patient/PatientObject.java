package com.hospital_doctor_patient;

import java.sql.Date;

public class PatientObject {

	private int pid,did,page;
	private float pwieght;
	private String pname,pemail;
	private Date d;
	
	public PatientObject(int pid, String pname,int page, float pwieght,String pemail, Date d,int did) {
		super();
		this.pid = pid;
		this.did = did;
		this.page = page;
		this.pwieght = pwieght;
		this.pname = pname;
		this.pemail = pemail;
		this.d = d;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public float getPwieght() {
		return pwieght;
	}

	public void setPwieght(float pwieght) {
		this.pwieght = pwieght;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPemail() {
		return pemail;
	}

	public void setPemail(String pemail) {
		this.pemail = pemail;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	@Override
	public String toString() {
		return "\n[pid=" + pid + ", did=" + did + ", page=" + page + ", pwieght=" + pwieght + ", pname="
				+ pname + ", pemail=" + pemail + ", d=" + d + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
