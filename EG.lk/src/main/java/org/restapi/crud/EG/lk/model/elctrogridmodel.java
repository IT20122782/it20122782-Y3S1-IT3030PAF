package org.restapi.crud.EG.lk.model;

public class elctrogridmodel {
	private int customerid;
	private String accountno;
	private int date;
	private int units;
	
public elctrogridmodel() {
		
	}
	
	public elctrogridmodel(int customerid, String accountno, int date, int units) {
		super();
		this.customerid = customerid;
		this.accountno = accountno;
		this.date = date;
		this.units = units;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	
}
